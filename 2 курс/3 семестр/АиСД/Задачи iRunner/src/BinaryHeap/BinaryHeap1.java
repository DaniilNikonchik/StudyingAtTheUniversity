package BinaryHeap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BinaryHeap1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        int n = Integer.parseInt(bf.readLine());
        int[] mas = new int[n];

        String[] buff = bf.readLine().split(" ");
        bf.close();
        for (int i = 0; i < n; i++) {
            mas[i] = Integer.parseInt(buff[i]);
        }
        for (int i = 0; i < n; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n) {
                if (mas[left] < mas[i]) {
                    fw.write("No");
                    fw.close();
                    return;
                }
            }
            if (right < n) {
                if (mas[right] < mas[i]) {
                    fw.write("No");
                    fw.close();
                    return;
                }
            }
        }
        fw.write("Yes");
        fw.close();
    }
}
