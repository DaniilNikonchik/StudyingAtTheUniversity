package Palindrome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Palindrome5 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader((new FileReader("input.txt")));
        FileWriter fw = new FileWriter("output.txt");
        String s = bf.readLine();
        //System.out.println(s);
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
        //String stroka = String.valueOf(makePalindrome(s));

        fw.write(String.valueOf(matrix[n][n]));
        //fw.write(String.valueOf(shortestPalindrome(stroka)));
        //fw.write('\n' + stroka);
        fw.close();
        bf.close();
    }


}

