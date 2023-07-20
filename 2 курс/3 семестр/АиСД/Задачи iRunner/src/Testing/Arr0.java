package Testing;

import java.util.Arrays;
import java.util.Scanner;

public class Arr0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < 5; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        System.out.print("Sorted array: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\nEnter the key: ");
        int key = scan.nextInt();
        int index = 0;
        for (int i = 0; i < 5; i++) {
            if (key == arr[i]) {
                index = i;
            }
        }
        System.out.print("Index: " + index);
    }
}
