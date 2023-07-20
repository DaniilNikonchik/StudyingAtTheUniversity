using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;

namespace Пятнашки
{
    public partial class Form1 : Form
    {
        Game game;
        private DateTime t1;
        private GameResult.ResultNode resultNode;
        private GameResult games_range;
        public DateTime T1 { get => t1; set => t1 = value; }

        public Form1() {
            InitializeComponent();
            timerSec.Stop();
            game = new Game(4);
           // timerSec.Interval = 1000;
            lDot.Visible = false;
            games_range = new GameResult();
            DeSerializeIt();
        }

        private void bt15_Click(object sender, EventArgs e){
            int position = Convert.ToInt16(((Button)sender).Tag);
            game.shift(position);
            counterLabel.Text = game.MotionCount.ToString();
            refresh();
            if (game.check_numbers()){
                timerSec.Stop();
                resultNode.Moving_number = (int)game.MotionCount;
                resultNode.Play_time = T1;
                WIN tmp = new WIN();
                tmp.ShowDialog();
                resultNode.User_name = tmp.Actor_name;
                games_range.InsertNewRecord(resultNode);
                SerializeIt();
            }
        }

        private Button bt (int position){
            switch (position) {
                case 0: return bt0;
                case 1: return bt1;
                case 2: return bt2;
                case 3: return bt3;
                case 4: return bt4;
                case 5: return bt5;
                case 6: return bt6;
                case 7: return bt7;
                case 8: return bt8;
                case 9: return bt9;
                case 10: return bt10;
                case 11: return bt11;
                case 12: return bt12;
                case 13: return bt13;
                case 14: return bt14;
                case 15: return bt15;
                default: return null;
            }
        }
        private void startGame_Click(object sender, EventArgs e){
            start_game();
        }

        private void start_game() {
            counterLabel.Text = "00";
            T1 = new DateTime(1, 1, 1, 0, 0, 0);
            resultNode = new GameResult.ResultNode();
            timerSec.Start();
            game.start();
            for (int j = 0; j < 5; j++){
                game.shift_random();
            }
            refresh();
            game.copy();
        }
        private void repeat_game(){
            counterLabel.Text = "00";
            T1 = new DateTime(1, 1, 1, 0, 0, 0);
            resultNode = new GameResult.ResultNode();
            timerSec.Start();
            game.repeat();
            refresh();
        }

        private void refresh () {
            for (int position = 0; position < 16; position++) {
                int nr = game.get_Number(position);
                bt(position).Text = nr.ToString();
                bt(position).Visible = (nr > 0);
            }
        }

        int sec = 0;
        int min = 0;

        private void timerSec_Tick(object sender, EventArgs e) {
           if (lDot.Visible) {
                T1 = T1.AddSeconds(1);
                if (sec < 59){
                    sec++;
                    if (sec < 10){
                        lSec.Text = "0" + sec.ToString();
                    } else {
                        lSec.Text = sec.ToString();
                    }
                } else {
                    if (min < 59) {
                        min++;
                        if (min < 10) {
                            lMin.Text = "0" + min.ToString();
                        } else  {
                            lMin.Text = min.ToString();
                        }
                        sec = 0;
                        lSec.Text = "00";

                    } else {
                        min = 0;
                        lMin.Text = "00";
                    }
                }
                lDot.Visible = false;
            } else {
                lDot.Visible = true;
            }
        }

        private void btStartGame_Click(object sender, EventArgs e) {
            sec = 0;
            min = 0;
            game.clear_tmp();
            start_game();
        }

        private void repeat_btn_Click(object sender, EventArgs e){
            sec = 0;
            min = 0;
            repeat_game();
        }
        //по продолжительности
        private void durationMenu_Click(object sender, EventArgs e){
            string temp = "";
            foreach (var x in games_range.ShowBestTime()) {
                temp += x.User_name + ": \t" + x.Start_time + " \t" + x.Play_time.TimeOfDay.ToString() + " \t" + x.Moving_number + "\n";
            }
            if (temp != "") {
                MessageBox.Show(temp, "Лучшие результаты по времени");
            }
            else MessageBox.Show("Список пуст");
        }
        //по количеству ходов
        private void countMenu_Click(object sender, EventArgs e){
            string temp = "";
            foreach (var x in games_range.ShowBestMoveResult()) {
                temp += x.User_name + ": \t" + x.Start_time + " \t" + x.Play_time.TimeOfDay.ToString() + " \t" + x.Moving_number + "\n";
            }
            if (temp != "") {
                MessageBox.Show(temp, "Лучшие результаты по количеству перемещений");
            }
            else MessageBox.Show("Список пуст");
        }

        private void to10pMenu_Click(object sender, EventArgs e){
            string temp = "";
            foreach (var x in games_range.ShowLastTen()) {
                temp += x.User_name + ": \t" + x.Start_time + " \t" + x.Play_time.TimeOfDay.ToString() + " \t" + x.Moving_number + "\n";
            }
            if (temp != "") {
                MessageBox.Show(temp, "Последние 10 результатов");
            }
            else MessageBox.Show("Список пуст");
        }
        
        private void deleteMenu_Click(object sender, EventArgs e){
            DeleteGameForm deldate = new DeleteGameForm(games_range);
            deldate.ShowDialog();
            games_range.SearchAndRemove(deldate.Ans);
            SerializeIt();
        }
        
        private void SerializeIt() {
            using (FileStream fs = new FileStream("Results.dat", FileMode.Create)) {
                BinaryFormatter bf = new BinaryFormatter();
                bf.Serialize(fs, games_range);
            }
        }
        private void DeSerializeIt() {
            try {
                using (FileStream fs = new FileStream("Results.dat", FileMode.Open)) {
                    BinaryFormatter bf = new BinaryFormatter();
                    games_range = (GameResult)bf.Deserialize(fs);
                }
            }
            catch (Exception) { }
        }


    }
}


        
