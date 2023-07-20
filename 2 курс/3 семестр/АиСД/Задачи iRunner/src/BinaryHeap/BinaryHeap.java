package BinaryHeap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BinaryHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");

        int matrix = Integer.parseInt(bf.readLine());
        String matrix_zna = bf.readLine();
        String[] words = matrix_zna.split(" ");
        int[] mas = new int[matrix + 1];
        int b = 0;
        for (int i = 1; i <= matrix; i++) {
            mas[i] = Integer.parseInt(words[b]);
            b++;
        }
        for (int i = matrix; i >= 2; ) {
            if (mas[i / 2] <= mas[i]) {
                i--;
            } else {
                fw.write("No");
                fw.close();
            }
        }
        fw.write("Yes");
        fw.close();
    }
}

