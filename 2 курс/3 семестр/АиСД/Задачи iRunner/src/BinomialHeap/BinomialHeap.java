package BinomialHeap;

import java.io.*;

public class BinomialHeap {
    public static void main(String[] args) throws Exception {
        long N;
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        N = Long.parseLong(br.readLine());
        FileWriter fw = new FileWriter("output.txt");
        int i = 0;
        while (N > 0) {
            if (N % 2 == 1) {
                fw.write(String.valueOf(i) + '\n');
            }
            N = N / 2;
            i++;
        }
        fw.close();
        br.close();
    }
}
