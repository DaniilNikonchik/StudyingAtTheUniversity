using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Events {
    public class ShotEventArgs : EventArgs{
        public int X;
        public int Y;
        public ShotEventArgs(int X, int Y){
            this.X = X;
            this.Y = Y;
        }
    }
    public class DisplayEventArgs : EventArgs {
        string result;
        public string Result { get => result; }
        public DisplayEventArgs(string str) : base(){
            result = str;
        }
    }
    public class Demonstrator{
        public Calculator calculator;
        public delegate void DisplayEventHandler(object sender, DisplayEventArgs e);
        public event DisplayEventHandler DisplayEvent;

        public delegate void StopEventHandler(object sender, EventArgs e);
        public event StopEventHandler StopEvent;

        public delegate void StartEventHandler(object sender, EventArgs e);
        public event StartEventHandler StartEvent;


        public int shot_pause;
        public int R;
        public delegate void GetShotEventHandler(object sender, ShotEventArgs e);
        public event GetShotEventHandler ShotEvent;
        Random X = new Random();
        Random Y = new Random();
        public Thread ShootThread;
       
        public Demonstrator(int shot_pause, int radius){
            this.shot_pause = shot_pause;
            this.R = radius;
            var shooting = new ShootingForm(this);
            shooting.Show();
            ShootThread = new Thread(StartShooting);
            ShootThread.Start();
        }
        public void CalcInit(int time){
            if (calculator == null || calculator.rest_time != time){
                calculator = new Calculator(time, this);
                calculator.Finished += Calculator_CalcFinish;
            } else {
                StartEvent(this, new EventArgs());
            }
        }
        private void Calculator_CalcFinish(object sender, CalculatorFinishEventArgs e) {
            string str = "На промежутке [" + e.num1.ToString() +";" + e.num2.ToString() + "] " + e.AutoMorph.ToString() +" автоморфных чисел!";
            DisplayEvent?.Invoke(this, new DisplayEventArgs(str));
        }
        public void StopCalc(){
            StopEvent?.Invoke(this, new EventArgs());
        }
        public void StartShooting(){ //START SHOOTING
            while (true){
                X = new Random();
                var XN = X.Next(-2 * R, 2 * R);
                //Thread.Sleep(shot_pause - 150);
                Y = new Random();
                var YN = X.Next(-2 * R, 2 * R);
                ShotEvent?.Invoke(this, new ShotEventArgs(XN, YN));
                Thread.Sleep(shot_pause);
            }
        }
    }
}
