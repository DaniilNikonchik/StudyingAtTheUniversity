using System;
using System.Collections.Generic;
using System.Text;
using System.Globalization;
namespace temperature
{
    class Class2
    {
        public double celcium
        {
            get;
            set;
        }
        public double fahrenheit
        {
            get { return 32 + 1.8 * celcium; }
            set { celcium = (value - 32) / 1.8; }
        }
        public override string ToString()
        {
            double rezt;
            char rezt1;
            if(CultureInfo.CurrentCulture.Name=="en-US")
            {
                rezt = fahrenheit;
                rezt1 = 'F';
            }
            else
            {
                rezt = celcium;
                rezt1 = 'C';
            }
            return String.Format("{0:##0.##}", rezt) + "'" + rezt1;
        }
    }
}
