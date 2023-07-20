package TheConfluenceOfIncreasingSequences;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TCOIS2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[m];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(m);
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                q.add(matrix[i][j]);
                if (q.size() == m + 1) {
                    fw.write(q.element() + " ");
                    q.poll();
                }
            }
        }
        while (!q.isEmpty()) {
            fw.write(String.valueOf(q.element()));
            q.poll();
            if (!q.isEmpty()) {
                fw.write(" ");
            }
        }
        fw.close();
    }
}

