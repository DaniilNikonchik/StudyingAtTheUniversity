using System;
using System.Threading;
using System.Collections.Generic;

namespace ThreadCsh {
    class MomDad {
        private string message;
        private int timeLag;
        private int repeats;
        private static Mutex mtx = new Mutex();

        public static int total = 10; //Общее количество повторений

        public MomDad(string aMessage, int aRepeats, int atimeLag){
            Set_Message(aMessage);
            Set_Repeats(aRepeats);
            Set_TimeLag(atimeLag);
        }
        public MomDad(){
            message = "Test";
            repeats = 1;
            timeLag = 1000;
        }
        private void Set_Message(string aMessage){
            this.message = aMessage;
        }
        private void Set_TimeLag(int atimeLag) {
            timeLag = atimeLag;
        }
        private void Set_Repeats(int aRepeats) {
            repeats = aRepeats;
        }
        public void Set(){
            Thread.Sleep(timeLag);

            while (repeats != 0 && total != 0){
                mtx.WaitOne();
                Console.WriteLine("--------------------------------------------------------------------------");
                Console.WriteLine($"ID треда: {Thread.CurrentThread.ManagedThreadId}" + " | Задержка: " +timeLag+" мс | Сообщение: "+message);
                Console.WriteLine("--------------------------------------------------------------------------");
                repeats--;
                mtx.ReleaseMutex();
                total--;
                Thread.Sleep(timeLag);
            }
        }

    } 
}
