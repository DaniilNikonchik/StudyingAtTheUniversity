using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using System.IO;

namespace DB_Connection
{
    internal class Client
    {
        public int Code { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
        public string Contact { get; set; }
    }

    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Подключаемся к базе данных онлайн-магазина:");
            OleDbConnection onlineShopConnection = new OleDbConnection(
                "Provider=Microsoft.ACE.OLEDB.12.0;Data Source =" +
                Path.Combine(Environment.CurrentDirectory, "Online_Shop.mdb"));
            onlineShopConnection.Open();

            string querySelectAllClients = "Select * from Клиент";

            List<Client> Clients = new List<Client>();
            using (OleDbCommand command = new OleDbCommand(querySelectAllClients, onlineShopConnection))
            {
                command.CommandType = CommandType.Text;
                OleDbDataReader dataReader = command.ExecuteReader();
                while (dataReader.Read())
                {
                    Clients.Add(new Client
                    {
                        Code = (int) dataReader["КОДКЛИЕНТА"],
                        Name = (string) dataReader["НАИМЕНОВАНИЕ"],
                        Address = (string) dataReader["АДРЕС"],
                        Contact = (string) dataReader["КОНТАКТ"]
                    });
                }

                dataReader.Close();
            }

            foreach (var client in Clients)
            {
                Console.WriteLine(
                    $"\n\nКлиент:\nКОД:{client.Code}\nНАИМЕНОВАНИЕ:{client.Name}\nАДРЕС:{client.Address}\nКОНТАКТ:{client.Contact}");

                var queryItems =
                    "SELECT t.* FROM [Товар] t WHERE t.КодТовара IN" +
                    "(SELECT sz.КодТовара FROM [Состав заказа] sz WHERE sz.НомерЗаказа IN" +
                    $"(SELECT z.НомерЗаказа FROM [Заказ] z WHERE z.КодКлиента = {client.Code} AND z.КодСостояния = 4 ))";
                OleDbCommand commandGetItems
                    = new OleDbCommand(queryItems, onlineShopConnection);

                Console.WriteLine("\nТовары клиента, которые были доставлены:\n");
                PrintItems(commandGetItems);
            }

            onlineShopConnection.Close();
        }

        private static void PrintItems(OleDbCommand myCommand)
        {
            using (OleDbDataReader myDataReader = myCommand.ExecuteReader())
            {
                do
                {
                    while (myDataReader.Read())
                    {
                        Console.WriteLine("***** Товар *****");
                        for (int i = 0; i < myDataReader.FieldCount; i++)
                        {
                            Console.WriteLine($"{myDataReader.GetName(i)} = {myDataReader.GetValue(i)}");
                        }

                        Console.WriteLine();
                    }
                } while (myDataReader.NextResult());
            }
        }
    }
}