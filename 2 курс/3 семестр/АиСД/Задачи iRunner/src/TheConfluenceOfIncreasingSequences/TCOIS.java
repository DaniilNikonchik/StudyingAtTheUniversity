package TheConfluenceOfIncreasingSequences;

import java.io.*;
import java.util.*;

public class TCOIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int mult = n * m;
        int[] arr = new int[mult];
        int k = 0;
        for (int i = 0; i < n; i++) {
            String[] string = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[k] = Integer.parseInt(string[j]);
                k++;
            }
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        String prob = " ";
        for (int j : arr) {
            sb.append(j);
            sb.append(prob);
        }
        fw.write(sb.toString().trim());
        fw.close();
    }
}