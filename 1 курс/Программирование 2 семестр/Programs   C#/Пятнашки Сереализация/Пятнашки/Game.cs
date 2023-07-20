using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Пятнашки{
    class Game {
        int size;
        int[,] map;
        List<int> tmp = new List<int>();
        int space_x, space_y;
        static Random random = new Random();
        private uint motionCount = 0;
        int count = 0;
        public uint MotionCount {
            get => motionCount;
            private set => motionCount = value;
        }

        public Game (int size){
            if (size < 2)
                size = 2;
            if (size > 5)
                size = 5;
            this.size = size;
            map = new int [size, size];
        }

        public void start(){
            for (int x = 0; x < size; x++)
                for (int y = 0; y < size; y++)
                    map[x, y] = coords_to_position(x, y) + 1;
            space_x = size - 1;
            space_y = size - 1;
            map[space_x, space_y] = 0;
            MotionCount = 0;
        }
        public void clear_tmp(){
            tmp.Clear();
        }
        public void copy() {
            for (int x = 0; x < size; x++)
                for (int y = 0; y < size; y++){
                    tmp.Add(map[x, y]);
                }
        }
        public void repeat(){
            int i = 0;
            for (int x = 0; x < size; x++)
                for (int y = 0; y < size; y++){
                    if (tmp[i] == 0) {
                        space_x = x;
                        space_y = y;
                    }
                    map[x, y] = tmp[i];
                    i++;
                }
            MotionCount = 0;
        }

        public void shift (int position){
            int x, y;
            position_to_coords(position, out x, out y);
            if (Math.Abs(space_x - x) + Math.Abs(space_y - y) != 1){
                return;
            }
            MotionCount++;
            map[space_x, space_y] = map[x, y];
            map[x, y] = 0;
            space_x = x;
            space_y = y;
        }

        public void shift_random(){
            int a = random.Next(0, 4);
            int x = space_x;
            int y = space_y;
            switch (a){
                case 0:
                    x--;
                    break;
                case 1: 
                    x++;
                    break;
                case 2: 
                    y--;
                    break;
                case 3: 
                    y++;
                    break;
            }
            shift(coords_to_position(x, y));
            MotionCount = 0;
        }

        public bool check_numbers(){
            if (!(space_x == size - 1 && space_y == size - 1))
                return false;
            for (int x = 0; x < size; x++){
                for (int y = 0; y < size; y++){
                    if (!(x == size - 1 && y == size - 1)){
                        if (map[x, y] != coords_to_position(x, y) + 1){
                            return false;
                        }
                    }
                }
            }           
            return true;

        }

        public int get_Number (int position) {
            int x, y;
            position_to_coords(position, out x, out y);
            if (x < 0 || x >= size)
                return 0;
            if (y < 0 || y >= size)
                return 0;
            return map[x, y];
        }

        private int coords_to_position (int x, int y){   // вспомогательная функция для координат, координаты переводим в позицию
            if (x < 0) {
                x = 0; 
            }
            if (x > size - 1) {
                x = size - 1; 
            }
            if (y < 0) { 
                y = 0; 
            }
            if (y > size - 1) { 
                y = size - 1; 
            }
            return y * size + x;
        }

        private void position_to_coords (int position, out int x, out int y){
            if (position < 0) {
                position = 0;
            }
            if (position > size * size - 1){
                position = size * size - 1;
            }
            x = position % size;
            y = position / size;
        }
    }
}
