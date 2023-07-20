using System;

namespace Fraction___new_version__
{
    class Program
    {
        static void Main(string[] args)
        {
            long numerator;
            long denominator;
            string input_strd;
            string input_strn;

            Fraction fraction_1 = new Fraction(1, 1);
            Console.WriteLine("Введите числитель и знаменатель для первой дроби: ");

            while (true)
            {
                input_strn = Console.ReadLine();
                input_strd = Console.ReadLine();
                numerator = long.Parse(input_strn);
                denominator = long.Parse(input_strd);
                try
                {
                    fraction_1.Set_Numerator(numerator);
                    fraction_1.Set_Denominator(denominator);
                    break;
                }
                catch (Exception exception)
                {

                    Console.WriteLine(exception.Message);
                }
            }

            Fraction fraction_2 = new Fraction(1, 1);
            Console.WriteLine("Введите числитель и знаменатель для второй дроби: ");

            while (true)
            {
                input_strn = Console.ReadLine();
                input_strd = Console.ReadLine();
                numerator = long.Parse(input_strn);
                denominator = long.Parse(input_strd);
                try
                {
                    fraction_2.Set_Numerator(numerator);
                    fraction_2.Set_Denominator(denominator);
                    break;
                }
                catch (Exception exception)
                {

                    Console.WriteLine(exception.Message);
                }
            }

            Console.WriteLine("Значение первой дроби: " + fraction_1.value_fraction());
            Console.WriteLine("Значение второй дроби: " + fraction_2.value_fraction());
            Console.WriteLine("Операция <: " + (fraction_1 < fraction_2));
            Console.WriteLine("Операция >: " + (fraction_1 > fraction_2));
            Console.WriteLine("Операция <=: " + (fraction_1 <= fraction_2));
            Console.WriteLine("Операция >=: " + (fraction_1 >= fraction_2));
            Console.WriteLine("Операция ==: " + (fraction_1 == fraction_2));
            Console.WriteLine("Операция !=: " + (fraction_1 != fraction_2));
            Console.WriteLine("Операция +: " + (fraction_1 + fraction_2).Get_Numerator() + " " + (fraction_1 + fraction_2).Get_Denominator());
            Console.WriteLine("Операция -: " + (fraction_1 - fraction_2).Get_Numerator() + " " + (fraction_1 - fraction_2).Get_Denominator());
            Console.WriteLine("Операция *: " + (fraction_1 * fraction_2).Get_Numerator() + " " + (fraction_1 * fraction_2).Get_Denominator());
            try
            {
                Console.WriteLine("Операция /: " + (fraction_1 / fraction_2).Get_Numerator() + " " + (fraction_1 / fraction_2).Get_Denominator());
            }
            catch (Exception exception)
            {
                Console.WriteLine(exception.Message);
            }

        }
    }

}