package TheDepthFirstSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TheDepthFirstSearch {
    public static boolean[] bool;
    public static int[] arr;
    public static int num = 0;
    public static int[][] matrix;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[n];
        }
        String[] Buff;
        int l = 0;
        for (int i = 0; i < n; i++) {
            Buff = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[l][j] = Integer.parseInt(Buff[j]);
            }
            ++l;
        }
        br.close();
        bool = new boolean[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            bool[i] = false;
        }
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[arr[i]] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            fw.write(res[i] + " ");
        }
        fw.close();
    }

    public static void dfs(int index) {
        if (bool[index]) {
            return;
        }
        bool[index] = true;
        arr[num++] = index;
        for (int i = 0; i < n; i++) {
            if (matrix[index][i] == 1) {
                if (bool[i]) {
                    continue;
                }
                dfs(i);
            }
        }
    }
}
