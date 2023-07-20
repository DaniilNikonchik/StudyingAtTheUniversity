using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Xml;

namespace XML {
    internal class Program { 
        //WITH STRUCTURE XML
        private static void DisplayTreeStructute(XmlNode node, int level) { 
            if (node.Name == "#text"){
                Console.WriteLine(node.Value);
                return;
            }

            Console.WriteLine("Level {0}, node name: {1}", level, node.Name);
            if (node.Attributes != null) {
                for (var i = 0; i < node.Attributes.Count; i++) {
                    Console.WriteLine("\t attribute {0}, name = {1}, " +
                                      "value =  {2}", i, node.Attributes[i].Name, node.Attributes[i].Value);
                }
                for (var i = 0; i < node.ChildNodes.Count; i++) {
                    DisplayTreeStructute(node.ChildNodes[i], level + 1);
                }
            }
        }
        //USER FRENDLY INTERFACE
        private static void DisplayTree(XmlNode node, int level) {
            if (node.Attributes != null) {
                for (var i = 0; i < node.Attributes.Count; i++) {
                    if (node.Attributes[i].Name == "date")
                        Console.WriteLine("\n[{0}]", node.Attributes[i].Value);
                    if (node.Attributes[i].Name == "number")
                        Console.Write("\n\t {0}. ", node.Attributes[i].Value);
                    if (node.Attributes[i].Name == "type")
                        Console.Write(" {0} ", node.Attributes[i].Value);
                    if (node.Attributes[i].Name == "name")
                        Console.Write("\t'{0}' ", node.Attributes[i].Value);
                    if (node.Attributes[i].Name == "teacher")
                        Console.Write(" Преподаватель: {0} ", node.Attributes[i].Value);
                }
                for (var i = 0; i < node.ChildNodes.Count; i++) { 
                    DisplayTree(node.ChildNodes[i], level + 1);
                }
            }
        }

        public static void Main(string[] args) {
            var xd = new XmlDocument();
            xd.Load("../../Schedule.xml");
            XmlNode root = xd.DocumentElement;
            int menu = 1;
            while (menu != 0){
                Console.WriteLine("*********************************************************");
                Console.WriteLine("*\tВыберите действие для отображения расписания:   *");
                Console.WriteLine("*\t1 - USER FRENDLY Version \t\t\t*");
                Console.WriteLine("*\t2 - с отображением XML структуры   \t\t*");
                Console.WriteLine("*\t0 - ВЫХОД \t\t\t\t\t*");
                Console.WriteLine("*********************************************************");
                menu = int.Parse(Console.ReadLine());
                //cin.ignore(numeric_limits < streamsize >::max(), '\n');
                if(menu == 1) {
                    DisplayTree(root, 0);
                    Console.WriteLine("\n");
                } else if (menu == 2) {
                    DisplayTreeStructute(root, 0);
                    Console.WriteLine("\n");
                }
            }
        }
    }
}