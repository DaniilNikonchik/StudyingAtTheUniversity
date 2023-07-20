package BuildAnAdjacencyMatrix;

import java.io.*;

public class BuildAnAdjacencyMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] matrix = new int[n][n];
        int a, b;
        for (int i = 0; i < m; i++) {
            s = bf.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            matrix[a - 1][b - 1] = matrix[b - 1][a - 1] = 1;
        }
        bf.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(matrix[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
