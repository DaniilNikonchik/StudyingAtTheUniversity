using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Lalala : Form
    {
        private int n1 = 0;
        private int n2 = 0;
        public Lalala()
        {
            InitializeComponent();
        }

        private void checkNumber(object sender, CancelEventArgs e, ref int n)
        {
            try
            {
                n = Int32.Parse((sender as TextBox).Text);
                erCheck.Clear();
            }
            catch (Exception ex)
            {
                //MessageBox.Show("Должно быть введено целое число");
                erCheck.SetError((sender as Control), "Должно быть введено целое число");
                e.Cancel = true;
            }
        }

        private void BtSum_Click(object sender, EventArgs e)
        {
            Rez.Text = (n1 + n2).ToString();
            erCheck.Clear();
        }

        private void btSum_MouseClick(object sender, MouseEventArgs e)
        {
            Rez.Text = (n1 + n2).ToString();
            erCheck.Clear();
        }

        private void BtComp_Click(object sender, EventArgs e)       
        {
            Rez.Text = (n1 * n2).ToString();
            erCheck.Clear();
        }

        private void BtDif_Click(object sender, EventArgs e)                                     
        {
            Rez.Text = (n1 - n2).ToString();
            erCheck.Clear();
        }

        private void BtPriv_Click(object sender, EventArgs e)                                             
        {
            Rez.Text = (n1 / n2).ToString();
            erCheck.Clear();
        }

        private void BtMax_Click(object sender, EventArgs e)                                              
        {
            Rez.Text = (n1 < n2).ToString();
            erCheck.Clear();
        }

        private void BtMin_Click(object sender, EventArgs e)                                              
        {
            Rez.Text = (n1 > n2).ToString();
            erCheck.Clear();
        }

        private void BtMaxEqually_Click(object sender, EventArgs e)
        {
            Rez.Text = (n1 <= n2).ToString();
            erCheck.Clear();
        }
        private void BtPercent_Click(object sender, EventArgs e)
        {
            Rez.Text = (n1 % n2).ToString();
            erCheck.Clear();
        }


        private void BtMinEqually_Click(object sender, EventArgs e)
        {
            Rez.Text = (n1 >= n2).ToString();
            erCheck.Clear();
        }

        private void tbN1_Validating(object sender, CancelEventArgs e)
        {
            checkNumber(sender, e, ref n1);
        }

        private void tbN2_Validating(object sender, CancelEventArgs e)
        {
            checkNumber(sender, e, ref n2);
        }

        private void Lalala_Load(object sender, EventArgs e)
        {
            tbN1.Text = n1.ToString();
            tbN2.Text = n2.ToString();
        }

        private void tbN2_Validated(object sender, EventArgs e)
        {
            if (n2 == 0)
                btPriv.Enabled = false;
            else
                btPriv.Enabled = true;
        }
    }
}
