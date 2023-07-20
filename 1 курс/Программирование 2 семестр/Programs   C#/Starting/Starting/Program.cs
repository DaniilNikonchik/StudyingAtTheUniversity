using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hello1
{
    class Program
    {
        static int Main(string[] args) // массив args
        {
            if (args.Length != 0) // своства массива Length
            {
                Console.Write("Hello");
                foreach (string s in args) // для каждой строки s из массива args
                    Console.Write(", " + s);
                Console.WriteLine("!");
            }
            else
                Console.WriteLine("Hello, world!");
            return 0;
        }
    }
}
