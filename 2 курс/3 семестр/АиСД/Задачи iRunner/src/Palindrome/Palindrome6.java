package Palindrome;

import java.io.*;

public class Palindrome6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader((new FileReader("input.txt")));
        FileWriter fw = new FileWriter("output.txt");

        String s = bf.readLine();
        char[] str = s.toCharArray();
        int len = s.length();
        int[][] res = new int[len][len];

        for (int i = 0; i < len; i++) {
            res[i][i] = 1;
        }

        if (len == 1) {
            res[0][0] = 1;
        } else if (len == 2) {
            for (int i = 0; i < len - 1; i++) {
                if (str[i] == str[i + 1]) {
                    res[i][i + 1] =2;
                } else {
                    res[i][i + 1] =1;
                }
            }
        } else {
            for (int k = 1; k < len; k++) {
                for (int i = 0; i < len - k; i++) {
                    int j = i + k;
                    if (str[i] == str[j])
                        res[i][j] =res[i + 1][j - 1] + 2;
                        else
                    res[i][j] = Math.max(res[i + 1][j], res[i][j - 1]);
                }
            }
        }

        int right = len - 1;
        int left = 0;
        int ansL = 0;
        int maxLength = res[0][len - 1];
        int ansR = maxLength - 1;

        char[] ans = new char[maxLength];
        //Console.write(ans.Length);
        while (left <= right) {
            if (left == right && res[left][right] == 1){
                ans[ansL] = str[left];
                ansL += 1;
                left += 1;
            }else{
                if (str[left] == str[right]) {
                    ans[ansL] = str[left];
                    ans[ansR] = str[right];
                    ansL += 1;
                    ansR -= 1;
                    right -= 1;
                    left += 1;
                } else {
                    if (res[left + 1][right] >= res[left][right - 1])
                    left++;
                        else
                    right--;
                }
            }
        }
        fw.write(String.valueOf(maxLength));
        char[] palindrome = new char[ans.length];
        for (int i = 0; i < ans.length; i++) {
            palindrome[i] = ans[i];
        }
        fw.write('\n' + String.valueOf(palindrome));
        bf.close();
        fw.close();
    }
}
