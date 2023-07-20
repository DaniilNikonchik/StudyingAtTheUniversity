package Frog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Frog {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        int[] arr = new int[n];
        int[] f = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        if (n == 1) {
            fileWriter.write(String.valueOf(arr[0]));
            fileWriter.close();
        } else if (n == 2) {
            fileWriter.write(String.valueOf(-1));
            fileWriter.close();
        } else {
            f[0] = arr[0];
            f[1] = 0;
            f[2] = arr[0] + arr[2];
            for (int i = 3; i < n; i++) {
                if (f[i - 2] < f[i - 3]) {
                    f[i] = arr[i] + f[i - 3];
                } else {
                    f[i] = arr[i] + f[i - 2];
                }
            }
            fileWriter.write(String.valueOf(f[n -1]));
            fileWriter.close();
        }
        return;
    }
}



/*
    f[0] = arr[0];
        f[1] = -1;
        f[2] = f[0] + arr[2];
        for (int i = 2; i < arr.length; i++) {
            f[i] = f[i - 2] + arr[i];
            if (i > 2) {
                f[i] = Math.max(f[i - 2], f[i - 3]) + arr[i];
            }
        }
        fileWriter.write(String.valueOf(f[n - 1]));
        fileWriter.close();



 */