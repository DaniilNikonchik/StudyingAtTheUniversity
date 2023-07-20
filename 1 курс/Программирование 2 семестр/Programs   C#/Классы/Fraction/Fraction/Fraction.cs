using System;
using System.Collections.Generic;
using System.Text;

namespace Fraction___new_version__
{
    class Fraction
    {
        private long numerator;
        private long denominator;

        public Fraction(long value_numerator, long value_denominator)
        {
            Set_Numerator(value_numerator, false);
            Set_Denominator(value_denominator);
            fractionshort();
        }

        public long nod(long a, long b)
        {
            if (b == 0)
            {
                return a;
            }
            if (nod(b, a % b) < 0)
            {
                return -(nod(b, a % b));
            }
            else
            {
                return (nod(b, a % b));
            }
        }

        public void fractionshort()
        {
            if (Get_Denominator() < 0)
            {
                Set_Denominator(-Get_Denominator());
                Set_Numerator(-Get_Numerator());
            }
            long nodx = nod(Get_Numerator(), Get_Denominator());
            Set_Numerator(Get_Numerator() / nodx);
            Set_Denominator(Get_Denominator() / nodx);
        }

        ~Fraction() { }

        public long Get_Numerator()
        {
            return numerator;
        }

        public void Set_Numerator(long value_numerator)
        {
            if (value_numerator == 0)
            {
                numerator = value_numerator;
                denominator = 1;
            }
            numerator = value_numerator / nod(value_numerator, denominator);
            denominator = denominator / nod(value_numerator, denominator);
        }

        public long Get_Denominator()
        {
            return denominator;
        }

        public void Set_Denominator(long value_denominator)
        {
            if (value_denominator == 0)
            {
                throw new Exception("Возникло деление на ноль!");
            }
            denominator = value_denominator / nod(numerator, value_denominator);
            numerator = numerator / nod(numerator, value_denominator);
        }

        public void Set_Numerator(long value_numerator, bool is_short)
        {
            if (value_numerator == 0)
            {
                numerator = value_numerator;
                denominator = 1;
            }
            if (is_short)
            {
                numerator = value_numerator / nod(value_numerator, denominator);
                denominator = denominator / nod(value_numerator, denominator);
                if (denominator < 0)
                {
                    numerator = (-numerator);
                    denominator = (-denominator);
                }
            }
            else
            {
                numerator = value_numerator;
            }
        }

        public double value_fraction()
        {
            if (numerator == 0 && denominator < 0)
            {
                return -((double)numerator / denominator);
            }
            return (double)numerator / denominator;
        }

        public static Fraction operator +(Fraction f1, Fraction f2)
        {
            return new Fraction(f1.numerator * f2.denominator + f2.numerator * f1.denominator, f1.denominator * f2.denominator);
        }

        public static Fraction operator -(Fraction f1, Fraction f2)
        {
            return new Fraction(f1.numerator * f2.denominator - f2.numerator * f1.denominator, f1.denominator * f2.denominator);
        }

        public static Fraction operator *(Fraction f1, Fraction f2)
        {
            return new Fraction(f1.numerator * f2.numerator, f1.denominator * f2.denominator);
        }

        public static Fraction operator /(Fraction f1, Fraction f2)
        {
            if (f2.numerator == 0)
            {
                throw new Exception("Возникло деление на ноль!");
            }
            return new Fraction(f1.numerator * f2.denominator, f1.denominator * f2.numerator);
        }

        public static Fraction operator -(Fraction f1)
        {
            if (f1.numerator == 0)
            {
                return new Fraction(f1.numerator, -(f1.denominator));
            }
            else
                return new Fraction(-(f1.numerator), f1.denominator);
        }

        public static bool operator ==(Fraction f1, Fraction f2)
        {
            return (f1.GetHashCode() == f2.GetHashCode());
        }

        public static bool operator !=(Fraction f1, Fraction f2)
        {
            return (f1.GetHashCode() != f2.GetHashCode());
        }

        public override int GetHashCode()
        {
            return value_fraction().GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if (obj == null)
                throw new NullReferenceException();
            if (!(obj is Fraction))
                throw new ArgumentException
                ("Данные должны быть в виде дроби");
            return (value_fraction() == (obj as Fraction).value_fraction());
        }

        public static bool operator >(Fraction f1, Fraction f2)
        {
            return ((f1.numerator * f2.denominator - f1.denominator * f2.numerator) > 0);
        }

        public static bool operator <(Fraction f1, Fraction f2)
        {
            return ((f1.numerator * f2.denominator - f1.denominator * f2.numerator) < 0);
        }

        public static bool operator >=(Fraction f1, Fraction f2)
        {
            return ((f1.numerator * f2.denominator - f1.denominator * f2.numerator) >= 0);
        }

        public static bool operator <=(Fraction f1, Fraction f2)
        {
            return ((f1.numerator * f2.denominator - f1.denominator * f2.numerator) <= 0);
        }

    }
}