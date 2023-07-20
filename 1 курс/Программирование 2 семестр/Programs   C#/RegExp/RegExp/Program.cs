using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace regexApp
{
    class Program
    {
        public static int ToDec(char ch)
        {
            if (ch == 'M')
                return 1000;
            if (ch == 'D')
                return 500;
            if (ch == 'C')
                return 100;
            if (ch == 'L')
                return 50;
            if (ch == 'X')
                return 10;
            if (ch == 'V')
                return 5;
            if (ch == 'I')
                return 1;
            return 0;
        }
        public static int ToArabic(string str)
        {
            int prev = ToDec(str[str.Length - 1]);
            int ans = prev;
            for (int i = str.Length - 2; i >= 0; i--)
            {
                int curr = ToDec(str[i]);
                if (curr >= prev)
                    ans += curr;
                else ans -= curr;
                prev = curr;
            }
            return ans;
        }
        static void Main(string[] args)
        {
            Regex regex = new Regex(@"\b(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})\b");
            List<Tuple<int, string>> listT = new List<Tuple<int, string>>();
            int count = 0;
            while (true)
            {
                Console.WriteLine("Введите имя файла (input.txt)");
                string path = Console.ReadLine();
                Console.WriteLine("Введите имя файла для вывода (Name.txt)");
                string path1 = Console.ReadLine();
                if (File.Exists(path))
                {
                    using (StreamReader sr = new StreamReader(path, System.Text.Encoding.Default))
                    {
                        string line;
                        while ((line = sr.ReadLine()) != null)
                        {
                            MatchCollection matches = regex.Matches(line);
                            if (matches.Count > 0)
                            {
                                foreach (Match match in matches)
                                {
                                    if (!(match.Length == 0))
                                    {
                                        listT.Add(new Tuple<int, string>(ToArabic(match.Value), match.Value));
                                        ++count;
                                    }
                                }
                            }
                        }
                        if (count == 0)
                        {
                            Console.WriteLine("Римских цифр не найдено");
                        }
                    }
                    listT = listT.OrderBy(a => a.Item1).ToList();
                    using (StreamWriter sw = new StreamWriter(path1, false, System.Text.Encoding.Default))
                    {
                        sw.WriteLine("\t\tВывод найденных чисел в порядке возрастания");
                        foreach (var x in listT)
                        {
                            sw.WriteLine($"{x.Item2,-15} ---> {x.Item1}");
                        }
                    }
                    break;
                }
                else
                {
                    Console.WriteLine("Такого файла нет! Попробуйте ещё раз");
                }
            }
        }
    }
}
