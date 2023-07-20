package Testing;

import java.util.Arrays;

public class Matrix1 {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        randomFilling(matrix);
        System.out.println("Matrix with numbers from the interval [0; 9]: ");
        printMatrix(matrix);

        System.out.println("The duplicate numbers: ");
        check(matrix);

    }

    public static int[][] randomFilling(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (int) (Math.random() * 9);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void check(int[][] matrix) {

    }
}
