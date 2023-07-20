using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Newtonsoft.Json.Schema;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json.Bson;
using System.IO;

namespace JSON {
    class Program {
        static void ParseJO(JObject a) {
            foreach (var item in a) {
                Console.Write(item.Key + ": ");
                if (item.Value is JArray) {
                    Console.WriteLine();
                    foreach (var item2 in item.Value) {
                        ParseJO(item2 as JObject);
                    }
                    Console.WriteLine("\n************************************************************\n");
                } else {
                    if (item.Value is JObject) {
                        Console.WriteLine();
                        ParseJO(item.Value as JObject);
                    } else {
                        Console.WriteLine(item.Value);
                    }
                }
                if (item.Key == "-teacher")
                    Console.WriteLine("------------------------------------------------");
            }
        }
        static void Main(string[] args) {
            JObject jo = JObject.Parse(File.ReadAllText("../../Schedule.json"));
            JSchema val = JSchema.Parse(File.ReadAllText("../../ScheduleSchema.json"));
            IList<string> err;
            
            if (jo.IsValid(val, out err))
                ParseJO(jo);
            else
                foreach (var item in err)
                    Console.WriteLine(item);
            Console.WriteLine("Нажмите ENTER для выхода из программы...");
            Console.ReadLine();

        }
    }
}
