package Laba2;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Matrix mat = new Matrix();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int size = scan.nextInt();
        int[][] matrix = new int[size][size];
        System.out.println("Initial matrix: \n");
        fillRandom(matrix);
        showMatrix(matrix);
        System.out.println("\nFinal matrix: \n");
        mat.sortByRows(matrix);
        showMatrix(matrix);
    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void fillRandom(int[][] matrix) {
        Random r = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int sign = r.nextBoolean() ? 1 : -1;
                matrix[i][j] = sign * r.nextInt(matrix.length);
            }
        }
    }

    public void sortByRows(int[][] matrix) {
        int size = matrix.length;
        int[] colsCharacter = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                colsCharacter[j] += Math.abs(matrix[i][j]);
            }
        }
        orderRows(matrix, colsCharacter);
    }

    private void orderRows(int[][] matrix, int[] colsCharacter) {
        int from = 0;
        while (from < matrix.length) {
            int indexToSwap = from;
            int max = colsCharacter[from];
            for (int i = from; i < matrix.length; i++) {
                if (colsCharacter[i] > max) {
                    max = colsCharacter[i];
                    indexToSwap = i;
                }
            }
            if (indexToSwap != from) {
                int tmp = colsCharacter[from];
                colsCharacter[from] = colsCharacter[indexToSwap];
                colsCharacter[indexToSwap] = tmp;
                swapRows(matrix, indexToSwap, from);
            }
            from++;
        }
    }

    public void swapRows(int[][] matrix, int index1, int index2) {
        int[] tmpArr = new int[matrix.length];
        int[] tmpArr2 = new int[matrix.length];
        copyRow(tmpArr, index1, matrix);
        copyRow(tmpArr2, index2, matrix);
        setRow(tmpArr, index2, matrix);
        setRow(tmpArr2, index1, matrix);
    }

    public void copyRow(int[] copyArr, int indexRow, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            copyArr[i] = matrix[i][indexRow];
        }
    }

    public void setRow(int[] newRow, int indexRow, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][indexRow] = newRow[i];
        }
    }


}

