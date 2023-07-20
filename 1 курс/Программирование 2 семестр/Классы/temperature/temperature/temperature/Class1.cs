using System;
using System.Collections.Generic;
using System.Text;

namespace temperature
{
    class Temperature
    {
        private double _celcium;

        public double Celcium { 
            get { return _celcium; } 
            set { _celcium = value; } 
        }
        public double Fahrenheit {
            get { return 32 + 1.8 * _celcium; } 
            set { _celcium = (value - 32) / 1.8; } 
        }
        public Temperature()
        {
            _celcium = 0;
        }
        public Temperature(double t)
        {
            _celcium = t;
        }
        public static Temperature operator + (Temperature t1, Temperature t2)
        {
            Temperature t = new Temperature();
            t._celcium = t1._celcium + t2._celcium;
            return t;

        }
        public static Temperature operator -(Temperature t1, Temperature t2)
        {
            Temperature t = new Temperature();
            t._celcium = t1._celcium - t2._celcium;
            return t;

        }
        public static Temperature operator -(Temperature t1)
        {
            Temperature t = new Temperature();
            t._celcium = -t1._celcium;
            return t;

        }
        public double getCelcium()
        {
            return _celcium;
        }
        public static bool operator < (Temperature t1, Temperature t2)
        {
            return (t1._celcium < t2._celcium);
        }
        public static bool operator >(Temperature t1, Temperature t2)
        {
            return (t1._celcium > t2._celcium);
        }
        public static bool operator ==(Temperature t1, Temperature t2)
        {
            return (t1._celcium == t2._celcium);
        }
        public static bool operator !=(Temperature t1, Temperature t2)
        {
            return (t1._celcium != t2._celcium);
        }
        public static bool operator <=(Temperature t1, Temperature t2)
        {
            return (t1._celcium <= t2._celcium);
        }
        public static bool operator >=(Temperature t1, Temperature t2)
        {
            return (t1._celcium <= t2._celcium);
        }
        public override bool Equals (object obj)
        {
            if (obj == null)
                throw new NullReferenceException();
            if (!(obj is Temperature))
                throw new ArgumentException("Argument should be Temperature type");
            return (_celcium == (obj as Temperature)._celcium);
        }
        public override int GetHashCode()
        {
            return _celcium.GetHashCode();
        }
        public static Temperature Parse (string s)
        {
            if (s == null) throw new ArgumentNullException();
            if (s.Length < 3) throw new FormatException
                    ("Parametr length is too small");
            if (!((s.Substring(s.Length - 2, 2)) == "'C") ||
                (s.Substring(s.Length - 2, 2) == "'c")) throw new FormatException
                         ("Parametr doesn't terminate by temperature mode");
            double d = Double.Parse(s.Substring(0, s.Length - 2));
            Temperature t = new Temperature();
            t._celcium = d;
            return t;
        }
        public override string ToString() {
            return String.Format("{0:##0.##}", _celcium) + "'C"; 
        }
    }
}
