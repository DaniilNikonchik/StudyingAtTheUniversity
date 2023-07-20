package Ones;

import java.util.Scanner;

public class Ones1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        System.out.println(score(N, K));
    }
    public static int score(int n, int m) {
        int k = n - m;
        if (m > k) {
            m = k;
        }
        if (m == 0) {
            return 1;
        }
        int akk = k = n - m + 1;
        k++;
        for (int i = 2; i <= m; i++, k++) {
            akk = akk / i * k + akk % i * k / i;
        }
        return akk;
    }
}