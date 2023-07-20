package Palindrome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Palindrome2 {

    public Palindrome2() throws IOException {
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader((new FileReader("input.txt")));
        String[] str = bf.readLine().split("");
        getPalindrome(str, str.length);
    }

    public static void getPalindrome(String[] str, int length) throws IOException {
        int[][] F = new int[length][length];
        for (int i = 0; i < length; i++)
            F[i] = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                F[i][j] = 0;
            }
            F[i][i] = 1;
        }
        for (int g = 1; g < length; g++) {
            for (int i = 0; i < length - g; i++) {
                int j = i + g;
                if (str[i] == str[j]) {
                    F[i][j] = F[i + 1][j - 1] + 2;
                } else {
                    if (F[i + 1][j] > F[i][j - 1]) F[i][j] = F[i + 1][j];
                    else F[i][j] = F[i][j - 1];
                }
            }
        }
        int left = 0, right = length - 1;
        int palR = F[0][length - 1] - 1, palL = 0;
        String[] result = new String[palR + 1];
        while (left <= right) {
            if (left == right && F[left][right] == 1) result[palL++] = str[left++];
            else {
                if (str[left] == str[right]) {
                    result[palL++] = str[left++];
                    result[palR--] = str[right--];
                } else {
                    if (F[left + 1][right] >= F[left][right - 1]) left++;
                    else right--;
                }
            }
        }
        FileWriter fw = new FileWriter("output.txt");
        fw.write(String.valueOf(F[0][length - 1]));
        fw.write('\n' + result[palR]);
        fw.close();
    }
}
