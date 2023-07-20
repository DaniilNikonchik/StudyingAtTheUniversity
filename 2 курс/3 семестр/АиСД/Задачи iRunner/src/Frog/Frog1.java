package Frog;

import java.io.*;

public class Frog1 {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("input.txt"));
        FileWriter fileWriter = new FileWriter("output.txt");
        int n = Integer.parseInt(file.readLine());
        String[] str = file.readLine().split(" ");
        file.close();
        if (n == 1) {
            fileWriter.write(String.valueOf(str[0]));
        } else if (n == 2) {
            fileWriter.write(String.valueOf(-1));
        } else {
            int[] f = new int[n];
            f[0] = Integer.parseInt(str[0]);
            f[1] = -1;
            f[2] = f[0] + Integer.parseInt(str[2]);
            for (int i = 3; i < n; i++) {
                f[i] = Math.max(f[i - 2], f[i - 3]) + Integer.parseInt(str[i]);
            }
            fileWriter.write(String.valueOf(f[n - 1]));
        }
        fileWriter.close();
    }
}
