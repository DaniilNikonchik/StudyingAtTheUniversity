package Testing;

import java.util.Arrays;

public class MagicMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {5, 7, 12}, {36, 40, 42}};
        System.out.println("First matrix: ");
        printMatrix(matrix1);

        System.out.println("******************************************************");

        System.out.println("Checking whether the first matrix is a magic square: ");
        check(matrix1, matrix1.length);

        System.out.println("******************************************************");

        int[][] matrix2 = {{5, 5, 5}, {5, 5, 5}, {5, 5, 5}};
        System.out.println("Second matrix: ");
        printMatrix(matrix2);

        System.out.println("******************************************************");

        System.out.println("Checking whether the second matrix is a magic square: ");
        check(matrix2, matrix2.length);
    }

    public static void check(int[][] matrix, int n) {
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0};
        int pos = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[pos] += matrix[i][j];
            }
            pos++;
        }
        System.out.println("Amount by line: " + arr[pos - 1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[pos] += matrix[j][i];
            }
            pos++;
        }
        System.out.println("Amount by table: " + arr[pos - 1]);

        for (int i = n; i > -1; i--) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    arr[pos] += matrix[i][j];
            }
        }
        System.out.println("Amount by secondary diagonal: " + arr[pos - 1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    arr[pos] += matrix[i][j];
            }
        }
        System.out.println("Amount by main diagonal: " + arr[pos - 1]);

        int value = arr[0], count = 0;
        for (int i = 0; i < pos; i++) {
            if (arr[i] == value) count++;
        }
        if (count == pos) {
            System.out.println("Magic square.");
        } else {
            System.out.println("Not a magic square");
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
