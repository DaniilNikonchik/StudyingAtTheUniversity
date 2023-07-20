using System;
using System.Text.RegularExpressions;

namespace Belarusian_Taxi
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int result = 0;
            Regex reg = new Regex(@"^(([1-7]T[AB]X|7TEX)[ ]([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]|[0-9][1-9][0-9]{2}|[1-9][0-9]{3}))$", RegexOptions.Compiled);
            for (int i = 0; i < n; i++)
                if (reg.IsMatch(Console.ReadLine()))
                    result++;
            Console.Write(result);
        }
    }
}


/*using System;
using System.Text.RegularExpressions;

namespace regexp
{
    class Program
    {
        static void Main(string[] args)
        {
            int Lines = int.Parse(Console.ReadLine());

            string Minsk_Patern = @"^(([1-7]T[AB]X|7TEX)[ ]([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]|[0-9][1-9][0-9]{2}|[1-9][0-9]{3}))$";
           // string Region_Patern = @"^[1-6]T[A | B]X\s[0-9]{4}$";

            string strinput;
            int count = 0;

            for (int i = 0; i < Lines; i++)
            {
                strinput = Console.ReadLine();

                if (Regex.IsMatch(strinput, Minsk_Patern))
                {
                    if (strinput[5] == '0' && strinput[6] == '0' && strinput[7] == '0' && strinput[8] == '0')
                        continue;
                    count++;
                }
            }
            Console.WriteLine(count);
        }
    }
}
*/
