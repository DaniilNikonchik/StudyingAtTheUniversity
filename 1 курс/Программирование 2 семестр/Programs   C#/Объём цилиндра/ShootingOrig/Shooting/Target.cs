using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Shooting
{
    public class Target
    {
        public int NumShots { get; }
        public int CurrentShots { get; private set; }
        public double Radius { get; }
        public int Successes { get; private set; }

        public Target(int numShots, double radius)
        {
            Radius = radius;
            NumShots = CurrentShots = numShots;
            Successes = 0;
        }

        public bool TryShoot(double x, double y)
        {
            if (CurrentShots == 0)
                throw new InvalidOperationException
                    ("Патроны закончились!");
            bool result = (x * x + y * y <= Radius * Radius);
            result &= !(x > 0 && y < 0);
            result &= !(x < 0 && y > 0 && (y > x + Radius));
            CurrentShots--;
            if (result)
                Successes++;
            return result;
        }
    }
}
