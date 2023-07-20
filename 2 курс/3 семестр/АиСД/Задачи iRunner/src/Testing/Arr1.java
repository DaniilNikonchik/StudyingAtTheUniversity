package Testing;

import java.util.Arrays;

public class Arr1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 68, 21, 43, 88, 13, 65, 94, 12, 32, 65, 8};
        System.out.println("array: " + Arrays.toString(arr));

        System.out.println("***********************************************************");

        System.out.print("Even elements: ");
        evenElements(arr);

        System.out.println();
        System.out.println("***********************************************************");

        System.out.print("The sum of the even elements: ");
        evenSum(arr);

        System.out.println();
        System.out.println("***********************************************************");

        System.out.print("Odd elements: ");
        oddElements(arr);

        System.out.println();
        System.out.println("***********************************************************");

        System.out.print("The sum of the odd elements: ");
        oddSum(arr);
    }

    public static void evenSum(int[] arr) {
        int evenSum = 0;
        for (int j : arr) {
            if (j % 2 == 0) {
                evenSum += j;
            }
        }
        System.out.print(evenSum);
    }

    public static void oddSum(int[] arr) {
        int oddSum = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                oddSum += j;
            }
        }
        System.out.print(oddSum);
    }

    public static void evenElements(int[] arr) {
        int evenElements;
        for (int j : arr) {
            if (j % 2 == 0) {
                evenElements = j;
                System.out.print(evenElements + " ");
            }
        }

    }

    public static void oddElements(int[] arr) {
        int oddElements;
        for (int j : arr) {
            if (j % 2 != 0) {
                oddElements = j;
                System.out.print(oddElements + " ");
            }
        }
    }
}
