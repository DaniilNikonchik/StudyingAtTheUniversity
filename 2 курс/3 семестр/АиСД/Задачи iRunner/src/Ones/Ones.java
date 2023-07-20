package Ones;

import java.math.BigInteger;
import java.util.Scanner;

public class Ones {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt() + 1;
        int K = scan.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = (int) ((arr[i - 1][j - 1] + arr[i - 1][j]) % (Math.pow(10, 9) + 7));
            }
        }
        System.out.println(BigInteger.valueOf(arr[N - 1][K]));
        //System.out.println(BigInteger.valueOf(2).pow(64));
    }
}