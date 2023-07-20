using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ShootingWF{
    public partial class Shooting : Form {
        private int R = 150;
        private int _allShoots = 0;
        private int _targetShoots = 0;
        List<Point> shoots = new List<Point>();

        public Shooting(){
            InitializeComponent();          
        }
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
            Point point3 = new Point(X0, Y0 + R);
            Point[] triangle = { point1, point2, point3 };

            g.FillPie(brushRed, X0 - R, Y0 - R, 2 * R, 2 * R, 0, -90);
            g.FillPolygon(brushRed, triangle);
        }
        private void DrawShoots(Graphics g) {
            Brush brush = new SolidBrush(Color.Green);
            foreach(var shoot in shoots) {
                g.FillEllipse(brush, shoot.X - 5, shoot.Y - 5, 10, 10);
            }
        }
        private void BEnterR_Click(object sender, EventArgs e){
            _allShoots = 0;
            _targetShoots = 0;
            LTShoots.Text = "Кол-во попаданий: 0";
            LAllShoots.Text = "Кол-во выстрелов: 0";
            shoots.Clear();
            Invalidate();
        }
        private void BShoot_Click(object sender, EventArgs e){
            int X;
            int Y;
            if (int.TryParse(TBXShoot.Text, out X) && int.TryParse(TBYShoot.Text, out Y)){
                int X0 = ClientRectangle.Width / 2 + 60;
                int Y0 = ClientRectangle.Height / 2;
                var shoot = new Point(X0 + X, Y0 - Y);
                shoots.Add(shoot);

                if ((((Math.Abs(X0 - shoot.X) + Math.Abs(Y0 - shoot.Y) <= R && shoot.X <= X0 && shoot.X >= X0 - R) && (shoot.Y >= Y0 && shoot.Y <= Y0 + R)) 
                    || (Math.Sqrt(Math.Pow(X0 - shoot.X, 2) + Math.Pow(Y0 - shoot.Y, 2)) <= R && (shoot.X >= X0 && shoot.X <= X0 + R) && (shoot.Y <= Y0 && shoot.Y >= Y0 - R)))){
                    _targetShoots += 1;
                    LTShoots.Text = "Кол-во попаданий: " + _targetShoots.ToString();
                }
                _allShoots += 1;
                LAllShoots.Text = "Кол-во выстрелов: " + _allShoots.ToString();
                Invalidate();
            } else {
                TBXShoot.Text = "";
                TBYShoot.Text = "";
                MessageBox.Show("Неправильные значения координат выстрела!");
            }
        }

        private void Form1_SizeChanged(object sender, EventArgs e){
            _allShoots = 0;
            _targetShoots = 0;
            LTShoots.Text = "Кол-во попаданий: 0";
            LAllShoots.Text = "Кол-во выстрелов: 0";
            shoots.Clear();
            Invalidate();
        }

    }
}
