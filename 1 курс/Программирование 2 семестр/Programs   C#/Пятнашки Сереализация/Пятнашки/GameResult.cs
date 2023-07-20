using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Пятнашки {
    [Serializable]
    public class GameResult
    {
        [Serializable]
        public class ResultNode : IComparable<ResultNode> {
            public String user_name;
            public DateTime start_time;
            public DateTime play_time;
            public int moving_number;

            public ResultNode(){
                Start_time = DateTime.Now;
            }

            public ResultNode(string _name, DateTime _start_time, DateTime _play_time, int _moving_number){
                user_name = _name;
                start_time = _start_time;
                play_time = _play_time;
                moving_number = _moving_number;
            }

            #region properties
            public string User_name { get => user_name; set => user_name = value; }
            public DateTime Start_time { get => start_time; set => start_time = value; }
            public DateTime Play_time { get => play_time; set => play_time = value; }
            public int Moving_number { get => moving_number; set => moving_number = value; }
            #endregion
            public int CompareTo(ResultNode other)
            {
                return (other.Start_time).CompareTo(this.start_time);
            }

        }

        public GameResult()
        {

        }

        public List<ResultNode> allrecords = new List<ResultNode>();

        private class PlayTimeCompare : IComparer<ResultNode>{
            int IComparer<ResultNode>.Compare(ResultNode x, ResultNode y){
                return x.Play_time.CompareTo(y.Play_time);
            }
        }

        private class MoveCompare : IComparer<ResultNode>
        {
            public int Compare(ResultNode x, ResultNode y)
            {
                return x.Moving_number.CompareTo(y.Moving_number);
            }
        }

        public List<ResultNode> ShowBestTime()
        {
            List<ResultNode> temp = new List<ResultNode>();
            temp.AddRange(allrecords);
            temp.Sort(new PlayTimeCompare());
            try
            {
                temp.RemoveRange(10, temp.Count - 10);
            }
            catch (ArgumentOutOfRangeException) { }
            catch (ArgumentException) { }
            return (temp);
        }

        public List<ResultNode> ShowBestMoveResult()
        {
            List<ResultNode> temp = new List<ResultNode>();
            temp.AddRange(allrecords);
            temp.Sort(new MoveCompare());
            try
            {
                temp.RemoveRange(10, temp.Count - 10);
            }
            catch (Exception) { }
            return (temp);
        }

        public List<ResultNode> ShowLastTen()
        {
            List<ResultNode> temp = new List<ResultNode>();
            int endrenge = (allrecords.Count < 10) ? (allrecords.Count) : 10;
            temp = allrecords.GetRange(0, endrenge);
            return (temp);
        }

        public List<ResultNode> ShowAll()
        {
            return allrecords;
        }

        public void InsertNewRecord(ResultNode temp)
        {
            allrecords.Add(temp);
            allrecords.Sort();
        }


        public void SearchAndRemove(DateTime latestDay)
        {

            int _of_region = allrecords.FindIndex(x => x.Start_time <= (latestDay));
            try
            {
                allrecords.RemoveRange(_of_region, (allrecords.Count - _of_region));
            }
            catch (Exception) { }
        }

    }
}
