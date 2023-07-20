using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Shooting
{
    public partial class InputForm : Form
    {
        public double Radius { get; private set; }
        public int NumShots { get; private set; }
        public InputForm()
        {
            InitializeComponent();
        }

        private void btShoot_Click(object sender, EventArgs e)
        {
            Radius = (double)nudRadius.Value;
            NumShots = (int)nudShots.Value;
            DialogResult = DialogResult.OK;
        }
    }
}
