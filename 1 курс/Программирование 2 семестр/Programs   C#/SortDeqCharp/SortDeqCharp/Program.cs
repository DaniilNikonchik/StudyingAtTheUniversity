using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace SortDeqCharp
{
    class Program
    {
        static void Main(string[] args)
        {
            if (!File.Exists("INSD.txt"))
                Console.WriteLine("Empty!");
            else
            {
                StreamReader sr = new StreamReader(@"C:\Users\dmin\Desktop\Прога\Programs   C#\SortDeqCharp\SortDeqCharp\INSD.txt");
                List<double> numbers = new List<double>();
                string line;
                while ((line = sr.ReadLine()) != null)
                {
                    numbers.Add(Double.Parse(line));
                }
                //cmp m = new cmp();
                numbers.Sort((double x, double y) => (Math.Abs(x).CompareTo(Math.Abs(y))));
                for (int i = 0; i < 5; i++)
                    Console.WriteLine(numbers[i]);
            }
            Console.ReadKey();
        }
    }
}



/**
 *        Старая сортировка 8 вариант на 10 баллов
 */
/*
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace SortDeqCharp
{     
     class cmp : IComparer<double>
     {
         public int Compare(double x, double y)
         {
             return Math.Abs(x).CompareTo(Math.Abs(y));   
    
         }
    
     }
    class Program
    {
        static void Main(string[] args)
        {
            if (!File.Exists("INSD.txt"))
                Console.WriteLine("Empty!");
            else
            {
                StreamReader sr = new StreamReader(@"C:\Users\dmin\Desktop\Прога\Programs   C#\SortDeqCharp\SortDeqCharp\INSD.txt");
                List<double> numbers = new List<double>();
                string line;
                while ((line = sr.ReadLine()) != null)
                {
                    numbers.Add(Double.Parse(line));
                }
                cmp m = new cmp();
                numbers.Sort(m);
                for (int i = 0; i < 5; i++)
                    Console.WriteLine(numbers[i]);
            }
            Console.ReadKey();
        }
    }
}*/