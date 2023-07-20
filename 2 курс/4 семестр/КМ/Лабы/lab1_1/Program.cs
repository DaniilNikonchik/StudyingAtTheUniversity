using System.IO;
using System;
namespace lab1_1
{    
    class Program
    {
        static void Main(string[] args)
        {
            StreamReader sr = new StreamReader("in.txt");
            StreamWriter sw = new StreamWriter("out.txt");

            string input = sr.ReadToEnd();

            Console.WriteLine("Choose method in substring chipher: ");

            SubstCipher subst = new SubstCipher();

            int op = 0;
            Console.WriteLine("Encript -'0'\nDecrypt - '1'");
            op = int.Parse(Console.ReadLine());
            if(op == 0)
            {
                subst.CreateKey();

                string key = subst.ReadKey();
                sw.Write(subst.Encrypt(input, key));
            }
            if(op == 1)
            {
                string key = subst.ReadKey();
                sw.Write(subst.Decrypt(input, key));
            }
                        
            sr.Close();
            sw.Close();
        }
    }
}
