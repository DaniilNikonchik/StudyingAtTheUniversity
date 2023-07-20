using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace pilots
{
    class Game
    {
        public bool[,] Tabel { 
            get; 
            private set; 
        }

        public Game() {
            Tabel = new bool [4, 4];
            Random rnd = new Random();
            do
            {
                for (int i = 0; i < 4; i++)
                    for (int j = 0; j < 4; j++)
                        Tabel[i, j] = (rnd.Next(2) > 0);
            }
            while (isFinished());
        }

        public bool isFinished()
        {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (!Tabel[i, j])
                        return false;
            return true;
        }

        public void reCalc(int r, int c) {
            for (int i = 0; i < 4; i++)
                Tabel[r, i] = !Tabel[r, i];
            for (int i = 0; i < 4; i++)
                Tabel[i, c] = !Tabel[i, c];
            Tabel[r, c] = !Tabel[r, c];
        }
    }
}
