using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;
namespace Events{
    public partial class ShootingForm : Form{
        Demonstrator creator;
        private int R;
        private int _allShoots = 0;
        private int _targetShoots = 0;
        List<Point> shoots = new List<Point>();
        protected override void OnPaint(PaintEventArgs e){
            base.OnPaint(e);
            DrawTarget(e.Graphics, R);
            DrawShoots(e.Graphics);
        }
        private void DrawTarget(Graphics g, int R){
            Pen pen = new Pen(Color.Black);
            int X0 = ClientRectangle.Width / 2 + 60;
            int Y0 = ClientRectangle.Height / 2;
            g.DrawLine(pen, X0, Y0, X0 + 3 * R, Y0);
            g.DrawLine(pen, X0, Y0, X0 - 3 * R, Y0);
            g.DrawLine(pen, X0, Y0, X0, Y0 + 3 * R);
            g.DrawLine(pen, X0, Y0, X0, Y0 - 3 * R);

            Brush brushRed = new SolidBrush(Color.Red);

            Point point1 = new Point(X0, Y0);
            Point point2 = new Point(X0 - R, Y0);
            Point point3 = new Point(X0, Y0 - R);
            Point[] triangle = { point1, point2, point3 };

            g.FillPie(brushRed, X0 - R, Y0 - R, 2 * R, 2 * R, 0, -90);
            g.FillPie(brushRed, X0 - R, Y0 - R, 2 * R, 2 * R, 90, 90);
            g.FillPolygon(brushRed, triangle);
        }

        private void DrawShoots(Graphics g){
            Brush brush = new SolidBrush(Color.Green);
            foreach (var shoot in shoots){
                g.FillEllipse(brush, shoot.X - 5, shoot.Y - 5, 10, 10);
            }
        }
        public void GetShot(object sender, ShotEventArgs e) {
            int X0 = ClientRectangle.Width / 2 + 60;
            int Y0 = ClientRectangle.Height / 2;
            var shoot = new Point(X0 + e.X, Y0 - e.Y);
            shoots.Add(shoot);

            if (InGoal(PixelToMathCoords(X0 + e.X, Y0 - e.Y))){
                 _targetShoots += 1;
                LTShoots.Invoke((MethodInvoker)(() => LTShoots.Text = "Кол-во попаданий: " + _targetShoots.ToString()));
            }
            _allShoots += 1;
            LAllShoots.Invoke((MethodInvoker)(() => LAllShoots.Text = "Кол-во выстрелов: " + _allShoots.ToString()));
            Invalidate();
        }

        private Point PixelToMathCoords(int X, int Y) {
            int X0 = ClientRectangle.Width / 2 + 60;
            int Y0 = ClientRectangle.Height / 2;
            int XM = X - X0;
            int YM = Y0 - Y;

            return new Point(XM, YM);
        }

        private bool InGoal(Point shoot) {
            //Если точка попала в 1 или 3 четверть графика, то нужно проверить,
            //лежит ли точка внутри окружности
            if (shoot.X * shoot.Y >= 0) {
                if (Math.Pow(shoot.X, 2) + Math.Pow(shoot.Y, 2) <= Math.Pow(R, 2)){
                    return true;
                }
                else {
                    return false;
                }
            }
            //Если точка лежит во 2 четверти, то нужно проверить,
            //лежит ли точка ниже прямой
            if (shoot.X <= 0 && shoot.Y >= 0) {
                if (shoot.Y <= shoot.X + R) {
                    return true;
                }
                else {
                    return false;
                }
            }
            //В противном случае, выстрел не попал по мишени
            return false;
        }

        public ShootingForm(Demonstrator creator){
            this.creator = creator;
            InitializeComponent();
            creator.ShotEvent += GetShot;
            this.R = creator.R;
        }
        private void button1_Click(object sender, EventArgs e){
            Form1 f = new Form1();
            creator.StopCalc();
            creator.ShootThread.Abort();
            button1.Enabled = false;
        }
        private void ShootingForm_FormClosing(object sender, FormClosingEventArgs e){
            creator.ShootThread.Abort();
        }
    }
}
