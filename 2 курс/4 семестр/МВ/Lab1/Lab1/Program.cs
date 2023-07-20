using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;

namespace ConsoleApp1
{


    class Program
    {
        public static void PrintMatrix(double[,] matrix)
        {
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < matrix.GetLength(0); j++)
                {
                    Console.Write(matrix[i, j].ToString("0.###\t"));
                }

                Console.WriteLine();
            }
        }

        public static void PrintVector(double[] vector)
        {
            for (int i = 0; i < vector.Length; i++)
            {
                Console.Write(vector[i].ToString("0.### "));
            }

            Console.WriteLine();
        }

        public static double[,] InitMatrix()
        {
            double[,] result;

            using (StreamReader sr = new StreamReader("Matrix.txt"))
            {
                List<string> strLines = new List<string>();
                string line = sr.ReadLine();

                while (line != null)
                {
                    strLines.Add(line);
                    line = sr.ReadLine();
                }

                result = new double[strLines.Count, strLines.Count];
                for (int i = 0; i < strLines.Count; i++)
                {
                    var tmpArr = strLines[i].Split(' ').
                        Select(x => double.Parse(x)).ToArray();
                    for (int j = 0; j < strLines.Count; j++)
                    {
                        result[i, j] = tmpArr[j];
                    }
                }
            }

            return result;
        }

        public static double[] InitVector()
        {
            double[] result;

            using (StreamReader sr = new StreamReader("Vector.txt"))
            {
                result = sr.ReadLine().Split(' ').Select(x => double.Parse(x)).ToArray();
            }

            return result;
        }

        private static double GetNorma(double[] vector) =>
            vector.Aggregate((x, y) => Math.Abs(x) + Math.Abs(y));

        private static double[] VectorDifference(double[] a, double[] b) =>
            new double[a.Length].Select((x, i) => x = a[i] - b[i]).ToArray();

        private static void ConditionTest(double[,] matrix, double[] vector)
        {
            double[] res1, res2;
            var vector2 = (vector.Clone() as double[]);
            vector2[0] -= 0.01;
            try
            {
                double determ;
                res1 = new GaussMethod(matrix, vector).GetSolution(out determ);
                res2 = new GaussMethod(matrix, vector2).GetSolution(out determ);
            }
            catch (GaussMethodSolutionNotFound e)
            {
                Console.WriteLine(e.Message);
                Console.ReadKey();
                return;

            }

            Console.WriteLine("\n**** Result of solution № 1****");
            PrintVector(res1);

            Console.WriteLine("\n**** Result of solution № 2****");
            PrintVector(res2);

            var diff1 = VectorDifference(vector, vector2);
            var diff2 = VectorDifference(res1, res2);

            var Norm1 = GetNorma(diff1) / GetNorma(vector);
            var Norm2 = GetNorma(diff2) / GetNorma(res1);

            if (Norm1 > Norm2)
            {
                Console.WriteLine("\nResult of comparison: ");
                Console.WriteLine("Error rate in the source date > Solution error rate \n");
            }

            if (Norm1 < Norm2)
            {
                Console.WriteLine("\nResult of comparison: ");
                Console.WriteLine("Solution error rate > Error rate in the source date\n");
            }

            var cond = Norm2 / Norm1;
            Console.WriteLine("\n**** Condition number ****");
            Console.WriteLine(cond.ToString("0.0##"));

            try
            {
                double determ;
                for (int i = 0; i < vector.Length; i++)
                {
                    var tmpVector = (vector.Clone() as double[]);
                    tmpVector[i] -= -0.01;
                    var tmpRes = new GaussMethod(matrix, tmpVector).GetSolution(out determ);

                    Console.WriteLine($"\n**** Result of solution with variable vector № {i + 1} ****");
                    PrintVector(tmpRes);
                }
            }
            catch (GaussMethodSolutionNotFound e)
            {
                Console.WriteLine(e.Message);
                Console.ReadKey();
                return;

            }
        }

        private static double[,] InitRandomMatrix(int size)
        {
            double[,] result = new double[size, size];
            Random rnd = new Random();

            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    result[i, j] = rnd.Next(100);
                }
            }

            return result;
        }

        private static double[] InitRandomVector(int size)
        {
            double[] result = new double[size];
            Random rnd = new Random();

            for (int i = 0; i < size; i++)
            {
                result[i] = rnd.Next(100);
            }

            return result;
        }

        private static void TimeTest()
        {
            using (StreamWriter sw = new StreamWriter("Time Statistic.txt"))
            {
                for (int i = 100; i <= 500; i += 100)
                {
                    double[,] matrix = InitRandomMatrix(i);
                    double[] vector = InitRandomVector(i);

                    Stopwatch stopwatch = new Stopwatch();
                    stopwatch.Start();
                    double determ;
                    new GaussMethod(matrix, vector).GetSolution(out determ);
                    stopwatch.Stop();

                    Console.WriteLine($"Time for a matrix with size {i}: {stopwatch.ElapsedMilliseconds}");
                    sw.WriteLine(stopwatch.ElapsedMilliseconds);
                }
            }
        }

        static void Main(string[] args)
        {
            double[,] matrix = InitMatrix();
            double[] vector = InitVector();

            Console.WriteLine("**** Matrix A ****");
            PrintMatrix(matrix);
            Console.WriteLine("\n**** Vector b ****");
            PrintVector(vector);

            double determ;
            double[] res;
            try
            {
                res = new GaussMethod(matrix, vector).GetSolution(out determ);

            }
            catch (GaussMethodSolutionNotFound e)
            {
                Console.WriteLine(e.Message);
                Console.ReadKey();
                return;

            }

            Console.WriteLine("\n**** Result of solution ****");
            PrintVector(res);
            Console.WriteLine("\n**** Determinant ****");
            Console.Write(determ.ToString("0.#####################\n"));

            ConditionTest(matrix, vector);
            TimeTest();

            Console.ReadKey();
        }
    }
}
