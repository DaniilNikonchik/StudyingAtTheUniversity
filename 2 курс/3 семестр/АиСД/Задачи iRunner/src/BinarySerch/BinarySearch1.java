package BinarySerch;

import java.util.Scanner;

public class BinarySearch1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int[] arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            System.out.print(BinarySearch1(array, arr[i])+ " " +
                    LowerBound(array, arr[i]) + " " +
                    UpperBound(array, arr[i]) + '\n');
        }
    }
    public static int BinarySearch1(int[] a, int x) {
        int l = 0;
        int r = a.length;
        while (l < r) {
            int k = (l + r) / 2;
            if (x == a[k]) {
                return 1;
            } else if (x < a[k]) {
                r = k;
            } else if (x > a[k]) {
                l = k + 1;
            }
        }
        return 0;
    }

    public static int UpperBound(int[] a, int x) {
        int l = 0;
        int r = a.length;
        while (l < r) {
            int k = (l + r) / 2;
            if (x < a[k]) {
                r = k;
            } else if (x >= a[k]) {
                l = k + 1;
            }
        }
        return l;
    }

    public static int LowerBound(int[] a, int x) {
        int l = 0;
        int r = a.length;
        while (l < r) {
            int k = (l + r) / 2;
            if (x <= a[k]) {
                r = k;
            } else if (x > a[k]) {
                l = k + 1;
            }
        }
        return l;
    }
}
