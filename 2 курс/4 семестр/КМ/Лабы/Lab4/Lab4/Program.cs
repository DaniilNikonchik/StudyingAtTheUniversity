using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Hash
{
    public static class Program
    {
        private const string FileNameText = "text.txt";

        public static void Main()
        {
            // преобразование данных в битвоый вид
            var text = new List<byte>(File.ReadAllBytes(FileNameText));

            // запись хэша в файл
            WriteFile(Hash(text));
        }

        private static byte[] Hash(List<byte> text)
        {
            //в случае если длина исходного массива битов не делится на цело на 32 бита(4 байта), то добиваем нулями
            for (var i = 0; i < text.Count % 4; i++)
                text.Add(0);

            //запись длины текста в конец массива блоков
            var length = text.Count;
            text.Add((byte)(length >> 24));
            text.Add((byte)(length >> 16));
            text.Add((byte)(length >> 8));
            text.Add((byte)length);


            //у0 = y - начальное значение
            var y = new byte[] { 50, 128, 77, 90 };

            // разбиение на блоки по 32 бита(4 байта)
            for (var i = 0; i < text.Count; i += 4)
            {
                var x = new[] { text[i], text[i + 1], text[i + 2], text[i + 3] };
                y = Sigma(x, y);
            }

            // итоговый хэш
            return y;
        }

        // F(x xor y, y) xor y
        private static byte[] Sigma(byte[] x, byte[] y) => Xor(F(y, Xor(x, y)), x);

        private static byte[] F(byte[] input, byte[] key)
        {
            var output = new byte[input.Length];
            input.CopyTo(output, 0);
            for (var j = 0; j < 8; j++)
            {
                for (var i = 0; i < input.Length; i += 2)
                {
                    var (x1, x2) = (output[i], output[i + 1]);
                    var tmp = x2 ^ key[j % 4];
                    var (s1, s2) = (SBox1(tmp >> 4 & 0xF) << 4, SBox2(tmp & 0xF));
                    tmp = s1 | s2;
                    tmp = CycleShiftLeft(tmp, 3);
                    tmp ^= x1;
                    (output[i], output[i + 1]) = (x2, (byte)tmp);
                }
            }

            return output;
        }

        #region
        private static int CycleShiftLeft(int a, int s) => ((a << s) & 0xFF) | (a >> 8 - s);
        private static int SBox1(int x) => (int)(Math.Pow(3, x) % 17 + 2) % 16;
        private static int SBox2(int x) => (int)(Math.Pow(5, x) % 17 + 7) % 16;

        private static byte[] Xor(byte[] a, byte[] b)
        {
            var output = new byte[a.Length];
            for (var i = 0; i < a.Length; ++i)
                output[i] = (byte)(a[i] ^ b[i]);
            return output;
        }
        private static void WriteFile(byte[] hash)
        {
            using var writer = new StreamWriter("OutHash.txt", true);
            foreach (var b in hash)
                writer.Write(BitFormat(b));
            writer.Write("\n");
        }

        private static void WriteConsole(byte[] hash)
        {
            foreach (var b in hash)
                Console.Write(BitFormat(b));
            Console.Write("\n");
        }
        private static string BitFormat(byte b) => $"{Convert.ToString(b, 2).PadLeft(8, '0')} ";

        private static int ArrayByte2Int(byte[] b)
            => Math.Abs(b[0] | (b[1] << 8) | (b[1] << 16) | (b[1] << 24));
        private static byte[] Int2ByteArray(int i)
            => new[] { (byte)(i >> 24), (byte)(i >> 16), (byte)(i >> 8), (byte)i };
        #endregion
    }
}