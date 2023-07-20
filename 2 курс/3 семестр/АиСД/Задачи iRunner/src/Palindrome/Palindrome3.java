package Palindrome;

import java.io.*;

public class Palindrome3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        String s = br.readLine();
        char[] string = s.toCharArray();
        int n = string.length;

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (string[i] == string[i + 1]) {
                arr[i][i + 1] = 2;
            } else {
                arr[i][i + 1] = 1;
            }
        }
        for (int i = 0; i < n - 2; i++) { //строка по диагон
            int j = i + 2; //колонка
            for (int k = i; k > -1; k--) { //строка вверх
                if (string[k] == string[j])
                    arr[k][j] = arr[k + 1][j - 1] + 2;
                else
                    arr[k][j] = Math.max(arr[k + 1][j], arr[k][j - 1]);
            }
        }
        writer.write(String.valueOf(arr[0][n - 1]) + "\n");
        int i = 0;
        int j = n - 1;
        String beg = null;
        String end = null;
        while (true) {
            if (i == j) {
                if (beg == null)
                    beg = String.valueOf(string[j]);
                else beg = beg + string[j];
                break;
            }
            if (arr[i][j] == 0) {
                break;
            }

            if (string[j] == string[i]) {
                if (beg == null)
                    beg = String.valueOf(string[j]);
                else beg = beg + string[j];
                if (end == null)
                    end = String.valueOf(string[j]);
                else end = string[j] + end;
                j--;
                i++;
                continue;
            }
            if (arr[i][j] == arr[i + 1][j]) {
                i++;
                continue;
            }
            if (arr[i][j] == arr[i][j - 1]) {
                j--;
                continue;
            }
            i++;
            j--;
        }
        if (end != null)
            writer.write(beg + end);
        else writer.write(beg);
        writer.close();
    }
}
