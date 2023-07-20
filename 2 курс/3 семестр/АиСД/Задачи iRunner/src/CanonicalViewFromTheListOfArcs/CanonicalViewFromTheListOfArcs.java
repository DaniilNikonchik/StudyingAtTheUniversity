package CanonicalViewFromTheListOfArcs;

import java.io.*;

public class CanonicalViewFromTheListOfArcs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n - 1; i++) {
            String[] ss = br.readLine().trim().split(" ");
            arr[Integer.parseInt(ss[1]) - 1] = Integer.parseInt(ss[0]);
        }
        br.close();
        FileWriter fw = new FileWriter("output.txt");
        for (int i = 0; i < n; i++) {
            fw.write(arr[i] + " ");
        }
        fw.close();
    }
}
