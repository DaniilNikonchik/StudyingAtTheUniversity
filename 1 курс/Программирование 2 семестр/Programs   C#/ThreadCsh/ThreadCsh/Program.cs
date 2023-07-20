using System;
using System.Threading;
using System.Collections.Generic;
using System.Text;

namespace ThreadCsh {
    class Program {
        static void Main(string[] args) {
            int menu;
            Console.WriteLine("******************************************************");
            Console.WriteLine("*            Выберите действие:                      *");
            Console.WriteLine("*            1 - использовать созданные объекты      *");
            Console.WriteLine("*            2 - создать свои объекты                *");
            Console.WriteLine("******************************************************");
            menu = int.Parse(Console.ReadLine());

            if (menu == 1) {
                MomDad mom = new MomDad("Это мама!", 1, 1000);
                MomDad dad = new MomDad("Это папа!", 2, 2000);
                MomDad parents = new MomDad("Это мы, родители!", 3, 3000);
                mom.Set();
                dad.Set();
                parents.Set();
            }
            else if (menu == 2){
                Console.WriteLine("******************************************************");
                Console.WriteLine("*            Введите общее число потоков:            *");
                Console.WriteLine("******************************************************");
                int n = int.Parse(Console.ReadLine());

                Thread[] threads = new Thread[n];
                MomDad[] tmp = new MomDad[n];
                string[] message = new string[n];
                int[] timeLag = new int[n];
                int[] repeats = new int[n];
                for (int i = 0; i < n; i++) {
                    Console.WriteLine("------------------------------------------------------");
                    Console.WriteLine("Введите сообщение №" + (i + 1) + ": ");
                    message[i] = Console.ReadLine();
                    Console.WriteLine("Сколько раз необходимо вывести сообщение?");
                    repeats[i] = int.Parse(Console.ReadLine());
                    Console.WriteLine("Введите величину задержки (в милисекундах): ");
                    timeLag[i] = int.Parse(Console.ReadLine());
                    Console.WriteLine("------------------------------------------------------");
                    tmp[i] = new MomDad(message[i], repeats[i], timeLag[i]);
                }
                for (int i = 0; i < n; i++) {
                    threads[i] = new Thread(new ThreadStart(tmp[i].Set));
                }
                for (int i = 0; i < n; i++) {
                    threads[i].Start();
                }
            } else {
                Console.WriteLine("Такого параметра не существует");
            }
        }
    }
}
