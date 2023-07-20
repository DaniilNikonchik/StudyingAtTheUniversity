using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
using System.Threading;

namespace Events {
    public class CalculatorFinishEventArgs: EventArgs
    {
        public BigInteger AutoMorph;
        public int num1;
        public int num2;
        public CalculatorFinishEventArgs(BigInteger AutoMorph, int A, int B){
            this.AutoMorph = AutoMorph;
            num1 = A;
            num2 = B;
        }
    }
    public class Calculator {
        public bool is_active = true;
        public int rest_time;
        private Random rand = new Random();
        Thread t;
        public Thread T { get => t; }
        static BigInteger[] AutoMorphs = new BigInteger[1001];
        
        public delegate void CalculatorFinishedEventHandler(object sender, CalculatorFinishEventArgs e);
        public event CalculatorFinishedEventHandler Finished;

        public Calculator(int rest_time, Demonstrator demonstrator){
            this.rest_time = rest_time;
            AutoMorphs[1] = 1;
            demonstrator.StopEvent += Demonstrator_StopEvent; 
            demonstrator.StartEvent += Demonstrator_StartEvent;
            ToStart();
        }
        private void ToStart(){
            is_active = true;
            t = new Thread(StartCalculations);
            t.Start();
        }
        private void StartCalculations(){ //CREATE [A;B] AND START FIND AUTOMORPHIC NUMBER
            while(is_active){
                int A = rand.Next(2, 1000000);
                int B = rand.Next(2, 1000000);
                if (!(A < B)){
                    while (A >= B){
                        A = rand.Next(2, 1000000);
                        B = rand.Next(2, 1000000);
                    }
                }
                Finished?.Invoke(this, new CalculatorFinishEventArgs(FindAutomorphicNumber(A, B), A, B));
                Thread.Sleep(rest_time);
            }
        }
        private void Demonstrator_StartEvent(object sender, EventArgs e){
            ToStart();
        }
        private void Demonstrator_StopEvent(object sender, EventArgs e){
            if (t.IsAlive){
                t.Abort();
                is_active = false;
                t.Join();
            }
        }
        static bool IsAutomorphic(string temp, string temp_sqr) { //HELPED FUNCTION FOR FINDED AUTOMORPHIC NUMBER
            for (int j = temp_sqr.Length - temp.Length, k = 0; j < temp_sqr.Length; ++j, ++k)
                if (temp_sqr[j] != temp[k])
                    return false;
            return true;
        }
        private BigInteger FindAutomorphicNumber(int num1, int num2){ //FINDED AUTOMORPHIC NUMBER
            long count = 0;
            string temp_sqr = string.Empty;
            string temp = string.Empty;

            for (long i = num1; i <= num2; ++i){
                if (IsAutomorphic(i.ToString(), (i * i).ToString()))
                    count++;
            }
            return count;          
        }
    }
}
