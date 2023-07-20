package Palindrome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Palindrome {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader((new FileReader("input.txt")));
        FileWriter fw = new FileWriter("output.txt");
        String s = bf.readLine();
        char[] str = s.toCharArray();
        int n = str.length;
        int[][] matrix = new int[7000][7000];
        for (int i = 0; i < n + 1; i++) {
            matrix[i] = new int[n + 1];
        }
        for (int j = 0; j < n + 1; j++) {
            matrix[j][0] = 0;
            matrix[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                if (str[i - 1] == str[n - j]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
            for (int j = i + 1; j < n + 1; j++) {
                if (str[j - 1] == str[n - i]) {
                    matrix[j][i] = matrix[j - 1][i - 1] + 1;
                } else {
                    matrix[j][i] = Math.max(matrix[j][i - 1], matrix[j - 1][i]);
                }
            }
        }
        String str1 = "";
        int h = 0;
        int j = n;
        for (int i = n; i > 0 && j > 0 && h < (matrix[n][n] + 1) / 2; ) {
            if (matrix[i][j] != matrix[i][j - 1] && matrix[i][j] != matrix[i - 1][j]) {
                str1 += str[i - 1];
                h++;
                if (j > 1) {
                    j--;
                    while (matrix[i][j] == matrix[i - 1][j] && i > 1) {
                        i--;
                    }
                    while (matrix[i][j] == matrix[i][j - 1] && j > 1) {
                        j--;
                    }
                } else {
                    break;
                }
            } else {
                if (i > 1) {
                    while (matrix[i][j] == matrix[i - 1][j] && i > 1) {
                        i--;
                    }
                    while (matrix[i][j] == matrix[i][j - 1] && j > 1) {
                        j--;
                    }
                } else {
                    j--;
                }
            }
        }
        for (int i = h; i < matrix[n][n]; i++) {
            str1 += str1.charAt(matrix[n][n] - i - 1);
        }
        fw.write(String.valueOf(matrix[n][n]));
        fw.write('\n' + str1);
        fw.close();
        bf.close();
    }
}
