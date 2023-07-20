using System;
using System.Linq;

namespace ConsoleApp1
{
    public class GaussMethodSolutionNotFound : Exception
    {
        public GaussMethodSolutionNotFound(string msg)
            : base($"Solution can't be found: {msg} \n")
        {
        }
    }

    class GaussMethod
    {
        private int[] transpositionX;
        private int size;
        
        public double[,] Matrix { get; }
        public double[] VectorB { get; }

        private void InitTransposition()
        {
            transpositionX = new int[size];
            transpositionX = transpositionX.Select((x, i) => x = i).ToArray();
        }

        public GaussMethod(double[,] matrix, double[] b)
        {
            Matrix = matrix.Clone() as double[,];
            VectorB = b.Clone() as double[];
            size = b.Length;
        }

        public double[] ReturnVectorDeterminant() // Return of the vector X and determinant 
        {
            InitTransposition();
            TDCOTGM();
            double[] tmpVector = RCOTGM();

            double[] result = new double[size];
            for (int i = 0; i < size; i++)
            {
                result[i] = tmpVector[transpositionX[i]];
            }

            return result;
        }

        public double[] GetSolution(out double determinant)
        {
            var result = this.ReturnVectorDeterminant();
            determinant = СountingDeterminant();
            return result;
        }

        public double СountingDeterminant() // Counting the determinant     
        {
            double result = 1;

            for (int i = 0; i < size; i++)
            {
                result *= Matrix[i, i];
            }

            return result;
        }

        private void RRAC(int dI, int i, int j) // Rearranging rowns and columns  
        {
            for (int k = 0; k < size; k++)
            {
                double tmpI = Matrix[k, dI];
                Matrix[k, dI] = Matrix[k, j];
                Matrix[k, j] = tmpI;
            }

            for (int k = 0; k < size; k++)
            {
                double tmpJ = Matrix[dI, k];
                Matrix[dI, k] = Matrix[i, k];
                Matrix[i, k] = tmpJ;
            }

            double tmpB = VectorB[dI];
            VectorB[dI] = VectorB[i];
            VectorB[i] = tmpB;

            int tmpX = transpositionX[dI];
            transpositionX[dI] = transpositionX[j];
            transpositionX[j] = tmpX;
        }

        private void FTMEITM(int dI) // Finding the maximum element in the matrix      
        {
            int maxI = 0;
            int maxJ = 0;
            double maxAbs = 0;

            for (int i = dI; i < size; i++)
            {
                for (int j = dI; j < size; j++)
                {
                    if (maxAbs < Math.Abs(Matrix[i, j]))
                    {
                        maxAbs = Math.Abs(Matrix[i, j]);
                        maxI = i;
                        maxJ = j;
                    }
                }
            }

            RRAC(dI, maxI, maxJ);
        }

        private void TDCOTGM() // The direct course of the Gauss method                      
        {
            for (int i = 0; i < size; i++)
            {
                FTMEITM(i);
                if (Math.Abs(Matrix[i, i]) == 0.00000001)
                {
                    throw new GaussMethodSolutionNotFound("Determinant are singular");
                }

                for (int j = i + 1; j < size; j++)
                {
                    double coeff = Matrix[j, i] / Matrix[i, i];
                    for (int k = i + 1; k < size; k++)
                    {
                        Matrix[j, k] -= Matrix[i, k] * coeff;
                    }
                    VectorB[j] -= VectorB[i] * coeff;
                }
            }
        }

        private double[] RCOTGM() // Reverse course of the Gauss method   
        {
            double[] result = new double[size];

            for (int i = size - 1; i >= 0; i--)
            {
                for (int j = i + 1; j < size; j++)
                {
                    VectorB[i] -= Matrix[i, j] * result[j];
                }
                result[i] = VectorB[i] / Matrix[i, i];
            }
            return result;
        }
    }
}
