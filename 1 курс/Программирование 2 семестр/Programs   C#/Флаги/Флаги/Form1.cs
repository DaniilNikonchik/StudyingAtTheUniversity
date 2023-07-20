using System;
using System.Drawing;
using System.Windows.Forms;

namespace Флаги
{
    public partial class Flags : Form
    {
        bool flag = true;
        public Flags()
        {
            InitializeComponent();
        }
        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            DrawFlag(ClientRectangle, e.Graphics);
        }
        private void DrawFlag(Rectangle r, Graphics g)
        {
            const int PROPX = 2, PROPY = 3;
            g.Clear(Color.Gray);

            int Height = r.Height, Width = r.Width;
            Point WN = new Point(0, 0);
            if (PROPX * r.Width > PROPY * r.Height) // слишком широкое поле
            {
                Width = Height * PROPY / PROPX;
                WN.X = (r.Width - Width) / 2;
            }
            else
                if (PROPX * r.Width < PROPY * r.Height) // слишком высокое поле
            {
                Height = Width * PROPX / PROPY;
                WN.Y = (r.Height - Height) / 2;
            }
            void DrowStar(double x0, double y0) // функция, рисующая звезду 
            {
                int n = 5;
                double R2 = Height / 12, R1 = R2 * 2 / 5;
                double alpha = 45;
                SolidBrush brush = new SolidBrush(Color.White);
                PointF[] points = new PointF[2 * n + 1];
                double da = Math.PI / n;
                double l;
                for (int k = 0; k < 2 * n + 1; k++)
                {
                    l = k % 2 == 0 ? R2 : R1;
                    points[k] = new PointF((float)(x0 + l * Math.Cos(alpha)),
                    (float)(y0 + l * Math.Sin(alpha)));
                    alpha += da;
                }
                g.FillPolygon(brush, points);
            }
            if (flag)
            {
                //Флаг Греции
                SolidBrush brush = new SolidBrush(Color.Blue);
                g.FillRectangle(brush, WN.X, WN.Y, Width, Height);
                brush.Color = Color.White;
                g.FillRectangle(brush, WN.X, WN.Y + Height * 1 / 9, Width, Height / 9);
                g.FillRectangle(brush, WN.X, WN.Y + Height * 3 / 9, Width, Height / 9);
                g.FillRectangle(brush, WN.X, WN.Y + Height * 5 / 9, Width, Height / 9);
                g.FillRectangle(brush, WN.X, WN.Y + Height * 7 / 9, Width, Height / 9);

                //квадрат с белым крестом
                brush.Color = Color.Blue;
                g.FillRectangle(brush, WN.X, WN.Y, Width * 4 / 10, Height * 5 / 9);
                brush.Color = Color.White;
                g.FillRectangle(brush, WN.X + (Width * 3 / 10) / 2, WN.Y, (Width * 4 / 12) / 4, Height * 5 / 9);
                brush.Color = Color.White;
                g.FillRectangle(brush, WN.X, WN.Y + (Height * 4 / 9) / 2, (Width * 4 / 10), (Height * 5 / 11) / 4);

                Font font = new Font("Courier New", 15, FontStyle.Bold | FontStyle.Italic);
                StringFormat drawFormat = new System.Drawing.StringFormat();
                brush.Color = Color.Black;
                g.DrawString(" Греция ", font, brush, 0, 0, drawFormat);
                brush.Dispose();
                font.Dispose();
            }
            else
            {
                // Флаг Боснии и Герцеговины
                Point[] DarkBluePart = new Point[3];
                Point A = new Point(WN.X + Width * 1 / 4, WN.Y);
                Point B = new Point(WN.X + Width * 3 / 4, WN.Y + Height);
                Point C = new Point(WN.X, WN.Y + Height);
                DarkBluePart[0] = A; DarkBluePart[1] = B; DarkBluePart[2] = C;
                SolidBrush brush = new SolidBrush(Color.DarkBlue);
                Pen pen = new Pen(brush);
                g.FillRectangle(brush, WN.X, WN.Y, Width, Height);
                brush.Color = Color.Yellow;
                g.FillRectangle(brush, WN.X + Width / 4, WN.Y, Width * 2 / 4, Height);
                pen.Color = Color.DarkBlue;
                g.DrawLine(pen, A, B);
                g.DrawLine(pen, B, C);
                brush.Color = Color.DarkBlue;
                g.FillPolygon(brush, DarkBluePart);

                //звезды
                DrowStar(WN.X + Width * 0.155, WN.Y);
                DrowStar(WN.X + Width * 0.215, WN.Y + Height * 1 / 8);
                DrowStar(WN.X + Width * 0.275, WN.Y + Height * 2 / 8);
                DrowStar(WN.X + Width * 0.340, WN.Y + Height * 3 / 8);
                DrowStar(WN.X + Width * 0.400, WN.Y + Height * 4 / 8);
                DrowStar(WN.X + Width * 0.465, WN.Y + Height * 5 / 8);
                DrowStar(WN.X + Width * 0.525, WN.Y + Height * 6 / 8);
                DrowStar(WN.X + Width * 0.585, WN.Y + Height * 7 / 8);
                DrowStar(WN.X + Width * 0.645, WN.Y + Height);
                brush.Color = Color.Gray;
                g.FillRectangle(brush, WN.X, WN.Y - Height, Width, Height);
                g.FillRectangle(brush, WN.X, WN.Y + Height, Width, Height);

                Font font = new Font("Courier New", 15, FontStyle.Bold | FontStyle.Italic);
                StringFormat drawFormat = new System.Drawing.StringFormat();
                brush.Color = Color.Red;
                g.DrawString(" Босния и Герцеговина", font, brush, 0, 0, drawFormat);
                brush.Dispose();
                font.Dispose();
            }
        }
        private void Form1_Resize_1(object sender, EventArgs e)
        {
            Invalidate();
        }
        private void Form1_Click(object sender, EventArgs e)
        {
            if (flag)
                flag = false;
            else
                flag = true;
            Invalidate();
        }
    }
}

