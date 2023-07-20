package BinarySerch;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        int n, k;
        Scanner scan = new Scanner(System.in);
        //System.out.println("Введите n:");
        n = scan.nextInt();
        int[] array = new int[n];
        //System.out.println("Введите элементы:");
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
            //scan.nextInt(array[i]);
        }
        //System.out.println("Введите k: ");
        k = scan.nextInt();
        int[] arr = new int[k];
        //System.out.println("Введите элементы:");
        for (int i = 0; i < k; i++) {
            arr[i] = scan.nextInt();
            //scan.nextInt(arr[i]);
            System.out.print(BinarySearch(arr[i], array, n) + " " +
                    LowerBound(arr[i], array, n) + " " +
                    UpperBound(arr[i], array, n) + '\n');
        }
    }

    public static int BinarySearch(int x, int[] array, int len) {
        int l = 0, r = len;
        while (l < r) {
            int k = (l + r) / 2;
            if (x == array[k]) {
                return 1;
            } else if (x < array[k]) {
                r = k;
            } else if (x > array[k]) {
                l = k + 1;
            }
        }
        return 0;
    }

    public static int LowerBound(int x, int[] array, int len) {
        int l = 0, r = len;
        while (l < r) {
            int k = (l + r) / 2;
            if (x <= array[k]) {
                r = k;
            } else if (x > array[k]) {
                l = k + 1;
            }
        }
        return l;
    }

    public static int UpperBound(int x, int[] array, int len) {
        int l = 0, r = len;
        while (l < r) {
            int k = (l + r) / 2;
            if (x < array[k]) {
                r = k;
            } else if (x >= array[k]) {
                l = k + 1;
            }
        }
        return l;
    }
}
