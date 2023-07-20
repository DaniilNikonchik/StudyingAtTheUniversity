package Testing;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix1 = new int[3][3];
        System.out.println("First matrix, filled in randomly: ");
        printMatrix(randomFilling(matrix1));

        int[][] matrix2 = {{1, 2, 3}, {5, 7, 12}, {36, 40, 42}};
        System.out.println("**************************************************************************");
        System.out.println("Second matrix, filled in using the keyboard: ");
        printMatrix(matrix2);

        int[][] matrix3 = addMatrix(matrix1, matrix2);
        System.out.println("**************************************************************************");
        System.out.println("Third matrix, the first plus the second matrix: ");
        printMatrix(matrix3);

        System.out.println("**************************************************************************");

        System.out.println("Maximum elements in the third matrix: " + getMax(matrix3));

        System.out.println("**************************************************************************");

        System.out.println("The arithmetic mean in the main diagonal of the third matrix: " + arithmeticMeanMain(matrix3));

        System.out.println("**************************************************************************");

        System.out.println("The arithmetic mean in the secondary diagonal of the third matrix: " + arithmeticMeanSecondary(matrix3));
    }

    public static int[][] randomFilling(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] matrix3 = new int[3][3];
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length; j++) {
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrix3;
    }

    public static int getMax(int[][] matrix) {
        int result = Integer.MIN_VALUE;
        for (int[] i : matrix) {
            for (int j : i) {
                result = Math.max(result, j);
            }
        }
        return result;
    }

    public static int arithmeticMeanMain(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (i == j) {
                    sum = sum + matrix[i][j];
                }
            }
        }
        sum = sum / 3;
        return sum;
    }

    public static int arithmeticMeanSecondary(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sum = sum + matrix[i][matrix.length - i - 1];
                i += 1;
            }
        }
        sum = sum/3;
        return sum;
    }
}
