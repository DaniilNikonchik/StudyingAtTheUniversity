package SumProblem;

import java.util.Scanner;

public class SumProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int q = scan.nextInt();
        int a = 0;
        int b = 0;
        answer = new int[q];
        scan.nextLine();
        for (int i = 0; i < q; i++) {
            String[] str = scan.nextLine().split(" ");
            if (str[0].equals("FindSum")) {
                a = Integer.parseInt(str[1]);
                b = Integer.parseInt(str[2]);
                answer[i] = findSum(a, b, n);
            }
            if (str[0].equals("Add")) {
                a = Integer.parseInt(str[1]);
                b = Integer.parseInt(str[2]);
                add(a, b);
                i--;
            }
        }
        for (int i = 0; i < q; i++) {
            System.out.println(answer[i]);
        }

    }

    public static int[] arr;
    public static int[] answer;
    public static int n;

    public static int findSum(int a, int b, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (a <= i && i < b) {
                sum += arr[i];
            }
        }
        return sum;
    }

    public static void add(int i, int x) {
        arr[i] += x;
        answer[i / n] += x;
    }
}

