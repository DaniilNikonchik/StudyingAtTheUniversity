using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ShootingWF
{
    
    public partial class Shooting : Form
    {
        private int R = 50;
        private int ShootsNum = 0;
        private int TargetShootsNum = 0;
    
        List<Point> shoots = new List<Point>();

        //Координаты центра графика
        int X0;
        int Y0;

        public Shooting()
        {
            InitializeComponent();

            //Вычислим координаты центра графика
            X0 = ClientRectangle.Width / 2 + 60;
            Y0 = ClientRectangle.Height / 2;
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
           
            DrawTarget(e.Graphics, R);
            DrawShoots(e.Graphics);
        }

        
     
        private void DrawTarget(Graphics g, int R)
        {
            Pen pen = new Pen(Color.LightSlateGray);
            
            g.DrawLine(pen, X0, Y0, X0 + 3 * R, Y0);//координатные оси
            g.DrawLine(pen, X0, Y0, X0 - 3 * R, Y0);//
            g.DrawLine(pen, X0, Y0, X0, Y0 + 3 * R);//
            g.DrawLine(pen, X0, Y0, X0, Y0 - 3 * R);//
           

            Brush brush = new SolidBrush(Color.RosyBrown);
         
            g.FillPie(brush, new Rectangle(X0 - R, Y0 - R, 2 * R, 2 * R), 270, 90);//сегмент в 1 четврети
            g.FillPie(brush, new Rectangle(X0 -  R, Y0-R, 2* R, 2 * R), 180, -90);//сегмент в 3 четвери
            Point[] aP = new Point[3];//треугольник
            aP[0].X = aP[1].X = X0;
            aP[0].Y = aP[2].Y = Y0;
            aP[1].Y = Y0 - R;
            aP[2].X = X0 - R;
            g.FillPolygon(brush, aP);

        }
        private void DrawShoots(Graphics g)
        {
            Brush brush = new SolidBrush(Color.DimGray);
            foreach(var shoot in shoots)
            {
                g.FillEllipse(brush, shoot.X - 5, shoot.Y - 5, 7, 7);
            }
        }
        //X, Y - координаты пикселя на форме
        private void Shoot(int X, int Y)
        {
            Point shoot = new Point(X, Y);
            shoots.Add(shoot);
            ShootsNum += 1;
            LAllShoots.Text = "All shoots: " + ShootsNum.ToString();

            if (InGoal(PixelToMathCoords(X, Y)))
            {
                TargetShootsNum += 1;
                LTShoots.Text = "Hits: " + TargetShootsNum.ToString();
            }
        }
        private void BEnterR_Click(object sender, EventArgs e)//ввод радиуса
        {
            int Radius;
            if (int.TryParse(TBRadius.Text, out Radius))
            {
                if (Radius <= 60 && Radius > 0)
                {
                    TBRadius.Text = "";
                    LCurRadius.Text = "Current radius:\n " + Radius.ToString();
                    R = Radius;
                    ShootsNum = 0;
                    TargetShootsNum = 0;
                    LTShoots.Text = "Hits: 0";
                    LAllShoots.Text = "All shoots:: 0";
                    shoots.Clear();
                    Invalidate();
                }
                else
                {
                    TBRadius.Text = "";
                    MessageBox.Show("Invalid radius value");
                    TBRadius.Select();
                }
            }
            else
            {
                MessageBox.Show("Radius must be an integer");
            }
        }

        private Point PixelToMathCoords(int X, int Y)
        {
            int XM = X - X0;
            int YM = Y0 - Y;

            return new Point(XM, YM);
        }
     
        private bool InGoal(Point shot)
        {
            //Если точка попала в 1 или 3 четверть графика, то нужно проверить,
            //лежит ли точка внутри окружности
            if (shot.X * shot.Y >= 0)
            {
                if (Math.Pow(shot.X, 2) + Math.Pow(shot.Y, 2) <= Math.Pow(R, 2))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }

            //Если точка лежит во 2 четверти, то нужно проверить,
            //лежит ли точка ниже прямой
            if (shot.X <= 0 && shot.Y >= 0)
            {
                if (shot.Y <= shot.X + R)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }

            //В противном случае, выстрел не попал по мишени
            return false;
        }

        private void BShoot_Click(object sender, EventArgs e) // ввод координат в поля Х Y ( обработка координат и попадания, счетчик выстрелов) 
        {
            int X;
            int Y;
            if (int.TryParse(TBXShoot.Text, out X) && int.TryParse(TBYShoot.Text, out Y))
            {
                Point pixelPoint = MathCoordsToPixelCoords(X, Y);
                Shoot(pixelPoint.X, pixelPoint.Y);
                Invalidate();
            }
            else
            {
                TBXShoot.Text = "";
                TBYShoot.Text = "";
                MessageBox.Show("Incorrect coordinate values ​​entered!");
            }
        }

        private void Form1_MouseClick(object sender, MouseEventArgs e) //обработка события выстрела 
        {
            var shoot = PointToClient(new Point(MousePosition.X, MousePosition.Y));
            Shoot(shoot.X, shoot.Y);
            Invalidate();
        }

        private Point MathCoordsToPixelCoords(int X, int Y)
        {
            int XP = X + X0;
            int YP = Y0 - Y;

            return new Point(XP, YP);
        }

        private void Form1_SizeChanged(object sender, EventArgs e)//обнуление счётчиков при изменении радиуса
        {
            ShootsNum = 0;
            TargetShootsNum = 0;
            LTShoots.Text = "Hits: 0";
            LAllShoots.Text = "All shoots: 0";
            shoots.Clear();
            Invalidate();
        }
      

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void TBRadius_TextChanged(object sender, EventArgs e)
        {

        }
        private void TBRestTime_TextChanged(object sender, EventArgs e)
        {
             
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void LCurRadius_Click(object sender, EventArgs e)
        {

        }

        private void LAllShoots_Click(object sender, EventArgs e)
        {

        }
    }
}
