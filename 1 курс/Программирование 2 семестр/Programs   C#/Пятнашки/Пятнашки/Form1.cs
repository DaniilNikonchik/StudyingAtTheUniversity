using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Пятнашки
{
    public partial class Form1 : Form
    {
        Game game;
        public Form1()
        {
            InitializeComponent();
            game = new Game(4);
           // timerSec.Interval = 1000;
            lDot.Visible = false;
        }

        private void bt15_Click(object sender, EventArgs e)
        {
            int position = Convert.ToInt16(((Button)sender).Tag);
            game.shift(position);
            refresh();
            if (game.check_numbers())
            {
                timerSec.Enabled = false;
                MessageBox.Show("Вы победили!");
                Application.Exit();
            }
        }

        private Button bt (int position)
        {
            switch (position)
            {
                case 0: return bt0;
                case 1: return bt1;
                case 2: return bt2;
                case 3: return bt3;
                case 4: return bt4;
                case 5: return bt5;
                case 6: return bt6;
                case 7: return bt7;
                case 8: return bt8;
                case 9: return bt9;
                case 10: return bt10;
                case 11: return bt11;
                case 12: return bt12;
                case 13: return bt13;
                case 14: return bt14;
                case 15: return bt15;
                default: return null;
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
           
            start_game();
        }

        private void startGame_Click(object sender, EventArgs e)
        {
            start_game();

        }

        private void start_game()
        { 
            game.start();
            for (int j = 0; j < 3; j++)
                game.shift_random();
            refresh();
        }

        private void btStartGame_Click(object sender, EventArgs e)
        {
            start_game();
        }

        private void refresh ()
        {
            for (int position = 0; position < 16; position++)
            {
                int nr = game.get_Number(position);
                bt(position).Text = nr.ToString();
                bt(position).Visible = (nr > 0);
            }
        }

        int sec = 0;
        int min = 0;
        //int microSec = 0;

        private void timerSec_Tick(object sender, EventArgs e)
        {
            //lSec.Text = "00";
           // lMin.Text = "00";

            if (lDot.Visible)
            {
                if (sec < 59)
                {
                    sec++;
                    if (sec < 10)
                    {
                        lSec.Text = "0" + sec.ToString();
                    }
                    else
                    {
                        lSec.Text = sec.ToString();
                    }
                }
                else
                {
                    if (min < 59)
                    {
                        min++;
                        if (min < 10)
                        {
                            lMin.Text = "0" + min.ToString();
                        }
                        else
                        {
                            lMin.Text = min.ToString();
                            
                        }
                        sec = 0;
                        lSec.Text = "00";

                    }
                    else
                    {
                        min = 0;
                        lMin.Text = "00";
                    }
                }
                lDot.Visible = false;
            }
            else
            {
                lDot.Visible = true;
            }
        }

        
    }
}
