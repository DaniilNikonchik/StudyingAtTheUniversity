using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Дурак
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            btNo.BringToFront();
            this.FormBorderStyle = FormBorderStyle.None;
            this.WindowState = FormWindowState.Maximized;
            this.TopMost = true;
        }

        private void BtYes_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Вы действительно дурак!");
            Application.Exit();
        }

        Random rnd = new Random();

        private void BtNo_Click(object sender, EventArgs e)
        {
            MessageBox.Show("И правда, не дурак!");
            Application.Exit();
        }

        private void TbKod_TextChanged(object sender, EventArgs e)
        {
            if (tbKod.Text == "2001")
            {
                btNo.Location = new Point(1127, 353);
                tbOtvet.Text = "Верный чит-код";
                
            }
        }

        private void btNo_MouseMove(object sender, MouseEventArgs e)
        {
            if (tbKod.Text != "2001")
            {
                btNo.Location = new Point(rnd.Next(this.Width - btNo.Width), rnd.Next(this.Height - btNo.Height));
            }
        }


        private void btNo_Enter(object sender, EventArgs e)
        {
            if (tbKod.Text != "2001")
            {
                tbKod.Focus();
            }
        }

        /*  protected override bool ProcessDialogKey(Keys keyData)
          {
              switch (keyData)
              {
                  case Keys.Tab:
                  case Keys.Left:
                  case Keys.Right:
                  case Keys.Down:
                  case Keys.Up:
                  case Keys.Shift:
                  case Keys.Enter:
                      return true;
                  default:
                      return base.ProcessDialogKey(keyData);
              }
          }*/

        /* private void Form1_MouseMove(object snder, MouseEventArgs e)
          {
              if (tbKod.Text != "2001")
              {
                  double length = Math.Sqrt(Math.Pow(MousePosition.X - btNo.Location.X, 2) + Math.Pow(MousePosition.Y - btNo.Location.Y, 2));
                  if (length < 170)
                  {

                      double sinus = (btNo.Location.Y - MousePosition.Y) / length;
                      double cosinus = (btNo.Location.X - MousePosition.X) / length;
                      if (sinus >= 0.5)
                      {
                          if (btNo.Top + 350 <= 1300)
                              btNo.Top += 18;
                          else
                              btNo.Location = new Point(1127, 353);
                      }

                      if (sinus <= -0.5)
                      {
                          if (btNo.Top - 40 >= 0)
                              btNo.Top -= 18;
                          else
                              btNo.Location = new Point(1127, 353);
                      }

                      if (cosinus >= 0.5)
                      {
                          if (btNo.Left + 350 <= 2000)   //+ btNo.Width 
                              btNo.Left += 18;
                          else
                              btNo.Location = new Point(1127, 353);
                      }

                      if (cosinus <= -0.5)
                      {
                          if (btNo.Left - 30 >= 0)
                              btNo.Left -= 18;
                          else
                              btNo.Location = new Point(1127, 353);
                      }
                  }
              }
          }*/
    }
}
