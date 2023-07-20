using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace pilots
{
    public partial class frmMain : Form
    {
        private Game g;
        public frmMain()
        {
            InitializeComponent();
        }

        private void frmMain_Load(object sender, EventArgs e)
        {
            g = new Game();
            dgwGame.RowCount = 4;
            dgwGame.ColumnCount = 4;
            showGrid();
        }

        private void showGrid()
        {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                {
                    if (g.Tabel[i, j])
                    {
                        dgwGame.Rows[i].Cells[j].Value = "open";
                        dgwGame.Rows[i].Cells[j].Style.BackColor = Color.Green;
                    }
                    else
                    {
                        dgwGame.Rows[i].Cells[j].Value = "lock";
                        dgwGame.Rows[i].Cells[j].Style.BackColor = Color.Firebrick;
                    }
                }
        }

        private void dwgGame_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            g.reCalc(e.RowIndex, e.ColumnIndex);
            showGrid();
            if (g.isFinished()) ;
            {
                MessageBox.Show("WIN");
                Close();
            }

        }
    }
}
