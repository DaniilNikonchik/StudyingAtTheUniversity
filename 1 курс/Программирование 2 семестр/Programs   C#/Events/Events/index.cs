using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Events{
    public partial class Form1 : Form{
        int count = 0;
        private int shoot_pause = 1000;
        private int shoot_size = 100;
        public Demonstrator demonstrator;
        public Form1(){
            InitializeComponent();     
        }
        private void Demonstrator_DisplayEvent(object sender, DisplayEventArgs e){
            TBResult?.Invoke((MethodInvoker)(
                () => TBResult.AppendText((++count) + ") " + e.Result + Environment.NewLine)));
        }
        private void BStart_Click(object sender, EventArgs e){ //START BTN
            int rest;
            if(int.TryParse(TBRestTime.Text, out rest)){
                if (int.Parse(TBShootPause.Text) > 0 && int.Parse(TBShootSize.Text) > 0){
                    shoot_pause = int.Parse(TBShootPause.Text);
                    shoot_size = int.Parse(TBShootSize.Text);
                    TBShootPause.Enabled = false;
                    TBShootSize.Enabled = false;
                    TBRestTime.Enabled = false;
                    BStart.Enabled = false;
                    BClear.Enabled = false;
                    Bstop.Enabled = true;
                    demonstrator = new Demonstrator(shoot_pause, shoot_size);
                    demonstrator.DisplayEvent += Demonstrator_DisplayEvent;
                    demonstrator.CalcInit(rest);
                } else {
                    MessageBox.Show("Некорректные параметры мишени!");
                }
            } else { 
                TBRestTime.Clear();
                MessageBox.Show("Некорректные параметры задержки вычислений!");
            }
        }
        private void button1_Click(object sender, EventArgs e) { //STOP BTN
            Bstop.Enabled = false;
            BStart.Enabled = true;
            BClear.Enabled = true;
            TBRestTime.Enabled = true;
            TBShootPause.Enabled = true;
            TBShootSize.Enabled = true;
            demonstrator.StopCalc();
        }
        private void BClear_Click(object sender, EventArgs e){ //CLEAR TEXTFORM
            TBResult.Clear();
        }
        private void Form1_FormClosing(object sender, FormClosingEventArgs e){
            demonstrator.calculator.T.Abort();
        }
    }
}
