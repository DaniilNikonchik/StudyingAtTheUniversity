using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Shooting
{
    public partial class ShootingForm : Form
    {
        private double unity, X, Y;
        private Target target;
        private int dimension;
        private LinkedList<PointF> dots;

        public ShootingForm()
        {
            InitializeComponent();
            X = Y = 0;
            dots = new LinkedList<PointF>();
        }

        private void ShootingForm_Load(object sender, EventArgs e)
        {

        }

        protected override void OnLoad(EventArgs e)
        {
            base.OnLoad(e);
            Hide();
            using (InputForm form = new InputForm())
            {
                form.ShowDialog();
                if (form.DialogResult == DialogResult.OK)
                {
                    target = new Target(form.NumShots, form.Radius);
                    dimension = pbTarget.Width;
                    unity = (dimension / 2) / target.Radius;
                    trbXCoord.Maximum = (int)Math.Ceiling(target.Radius * 10);
                    trbXCoord.Minimum = (int)Math.Floor(-target.Radius * 10);
                    trbYCoord.Maximum = (int)Math.Ceiling(target.Radius * 10);
                    trbYCoord.Minimum = (int)Math.Floor(-target.Radius * 10);
                    Show();
                }
                else
                    Close();
            }
        }
        private void pbTarget_Paint(object sender, PaintEventArgs e)
        {
            drawTarget(e.Graphics);
        }

        private void drawTarget(Graphics targetGraph)
        {
            targetGraph.SmoothingMode = SmoothingMode.AntiAlias;

            PointF[] point2 = {new PointF(dimension / 2.0f, dimension / 2.0f),
                                new PointF(dimension / 2.0f, 0),
                                new PointF(0, dimension / 2.0f)};

            targetGraph.FillPolygon(new SolidBrush(Color.White), point2);
            targetGraph.FillPie(new SolidBrush(Color.White), pbTarget.ClientRectangle, 90, 90);
            targetGraph.FillPie(new SolidBrush(Color.White), pbTarget.ClientRectangle, 270, 90);

            targetGraph.DrawLine(Pens.Black, dimension / 2.0f, 0,
                                    dimension / 2.0f, dimension);
            targetGraph.DrawLine(Pens.Black, 0, dimension / 2.0f,
                                    dimension, dimension / 2.0f);
            targetGraph.DrawLine(Pens.Black, 0, dimension / 2.0f,
                        dimension / 2.0f, 0);

            targetGraph.DrawEllipse(Pens.Black, pbTarget.ClientRectangle);

            double fiveSegments = dimension / 10.0;
            int inUnities = (int)(fiveSegments / unity);
            if (inUnities == 0)
                inUnities = 1;
            using (Font font = new Font(FontFamily.GenericMonospace, 12))
            {
                for (int i = 0; unity * inUnities * i <= dimension / 2.0; ++i)
                {
                    targetGraph.DrawString((inUnities * i).ToString(),
                         font, Brushes.Black,
                         toPointF(toFormCoords(inUnities * i, 0)));

                    targetGraph.DrawLine(Pens.Black,
                         toPointF(toFormCoords(inUnities * i, -inUnities * 0.05)),
                         toPointF(toFormCoords(inUnities * i, inUnities * 0.05)));

                    targetGraph.DrawString((inUnities * i).ToString(),
                         font, Brushes.Black,
                         toPointF(toFormCoords(0, inUnities * i)));

                    targetGraph.DrawLine(Pens.Black,
                         toPointF(toFormCoords(-inUnities * 0.05, inUnities * i)),
                         toPointF(toFormCoords(inUnities * 0.05, inUnities * i)));

                    targetGraph.DrawString((-inUnities * i).ToString(),
                         font, Brushes.Black,
                         toPointF(toFormCoords(0, -inUnities * i)));

                    targetGraph.DrawLine(Pens.Black,
                         toPointF(toFormCoords(-inUnities * 0.05, -inUnities * i)),
                         toPointF(toFormCoords(inUnities * 0.05, -inUnities * i)));

                    targetGraph.DrawString((-inUnities * i).ToString(),
                          font, Brushes.Black,
                          toPointF(toFormCoords(-inUnities * i, 0)));

                    targetGraph.DrawLine(Pens.Black,
                         toPointF(toFormCoords(-inUnities * i, -inUnities * 0.05)),
                         toPointF(toFormCoords(-inUnities * i, inUnities * 0.05)));
                }
            }
            foreach (PointF dot in dots)
            {
                drawDot(Brushes.DarkMagenta, dot, 3, targetGraph);
            }
        }


        private (double x, double y) toFormCoords
            (double coordX, double coordY) =>
            (coordX * unity + dimension / 2.0,
            -coordY * unity + dimension / 2.0);
        private PointF toPointF
            ((double x, double y) tuple) =>
            new PointF((float)tuple.x, (float)tuple.y);
        private (double x, double y) toCoords
            (int formCoordX,int formCoordY) => 
            ((formCoordX - dimension / 2.0) / unity,
            -(formCoordY - dimension / 2.0) / unity);

        private void shoot
           (double x, double y)
        {
            try
            {
                target.TryShoot(x, y);
                dots.AddLast(toPointF(toFormCoords(x, y)));
                updateInfo();
                pbTarget.Invalidate();
            }
            catch (Exception ex)
            {
                MessageBox.Show
                   (
                       ex.Message,
                       "Ошибочка вышла!",
                       MessageBoxButtons.OK,
                       MessageBoxIcon.Error
                   );
            }
        }

        private void updateInfo()
        {
            lbShots.Text = $"{target.CurrentShots} / {target.NumShots}";
            lbSuccesses.Text = $"{target.Successes}";
            lbFailures.Text = $"{target.NumShots - target.CurrentShots - target.Successes}";
        }

        private void drawDot(Brush brush, PointF point,
                            float radius, Graphics targetGraph)
        {
            point.X -= radius;
            point.Y -= radius;

            targetGraph.FillEllipse
                (brush, new RectangleF
                 (point, new SizeF(2 * radius, 2 * radius)));
        }

        private void pbTarget_MouseClick(object sender, MouseEventArgs e)
        {
            (double X, double Y) = toCoords(e.X, e.Y);
            shoot(X, Y);
        }

        private void validating (object sender, CancelEventArgs e, out double alpha)
        {
            var alphaBox = sender as TextBox;
            if (!double.TryParse(alphaBox.Text, out alpha))
            {
                e.Cancel = true;
                alphaBox.Text = "0";
                alphaBox.SelectAll();
            }
        }

        private void tbXCoord_Validating(object sender, CancelEventArgs e)
        {
            validating(sender, e, out X);
        }

        private void tbYCoord_Validating(object sender, CancelEventArgs e)
        {
            validating(sender, e, out Y);
        }

        private void btShoot_Click(object sender, EventArgs e)
        {
            shoot(X, Y);
        }

        private void trbXCoord_Scroll (object sender, EventArgs e)
        {
            X = trbXCoord.Value / 10.0;
            tbXCoord.Text = (trbXCoord.Value / 10.0).ToString();
        }
        private void trbYCoord_Scroll(object sender, EventArgs e)
        {
            Y = trbYCoord.Value / 10.0;
            tbYCoord.Text = (trbYCoord.Value/10.0).ToString();
        }
    }
}
