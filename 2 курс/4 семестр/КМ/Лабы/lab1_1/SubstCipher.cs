using System;
using System.IO;

namespace lab1_1
{
    class SubstCipher
    {
        string alphabet = "abcdefghijklmnopqrstuvwxyz";

        public string Encrypt(string text, string key)
        {
            string encryptText = "";
            text = text.ToLower();

            foreach (var ch in text)
            {
                encryptText += key[alphabet.IndexOf(ch)];
            }

            return encryptText;
        }

        public string Decrypt(string text, string key)
        {
            string decryptText = "";
            text = text.ToLower();

            foreach (var ch in text)
            {
                decryptText += alphabet[key.IndexOf(ch)];
            }

            return decryptText;
        }

        public string Shuffle(string text)
        {
            Random rnd = new Random();
            char[] textArr = text.ToCharArray();

            foreach (var t in text)
            {
                var rndPos1 = rnd.Next(0, text.Length);
                var rndPos2 = rnd.Next(0, text.Length);
                var temp = textArr[rndPos1];

                textArr[rndPos1] = textArr[rndPos2];
                textArr[rndPos2] = temp;
            }

            return new string(textArr);
        }

        public void CreateKey()
        {
            using (var sw = new StreamWriter("key.txt"))
            {
                sw.Write(Shuffle(alphabet));
            }
        }

        public string ReadKey()
        {
            using (var sr = new StreamReader("key.txt"))
            {
                return sr.ReadToEnd();
            }
        }
    }
}
