using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class AlarmEventArgs : EventArgs
{
    DateTime alarmTime;
    public AlarmEventArgs(DateTime time)
    {
        alarmTime = time;
    }
    public DateTime Time
    {
        get { return alarmTime; }
    }

}
public delegate void AlarmEventHandler(object sender, AlarmEventArgs e);

