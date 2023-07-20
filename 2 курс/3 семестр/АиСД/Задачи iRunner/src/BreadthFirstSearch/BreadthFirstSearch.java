package BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BreadthFirstSearch {
    public static int I = 1;
    public static int n;

    public static boolean[] bool;
    public static List<Integer> list;

    public static void bfs(int[][] matrix, int[] res, int i) {
        if (bool[i]) {
            return;
        }
        list.add(i);
        bool[i] = true;
        res[i] = I++;

        if (list.size() != 0) {
            do {
                i = list.get(0);
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        if (!bool[j]) {
                            list.add(j);
                            bool[j] = true;
                            res[j] = I++;
                        }
                    }
                }
                list.remove(0);
            } while (list.size() != 0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        int[] result = new int[n];
        bool = new boolean[n];
        list = new ArrayList<>(n);
        String[] str;
        {
            int i = 0;
            while (i < n) {
                str = br.readLine().split(" ");
                int j = 0;
                while (j < n) {
                    matrix[i][j] = Integer.parseInt(str[j]);
                    j++;
                }
                i++;
            }
        }

        IntStream.range(0, n).forEach(i -> bfs(matrix, result, i));

        int i = 0, resultLength = result.length;
        while (i < resultLength) {
            Integer u = result[i];
            fw.write(u + " ");
            i++;
        }
        fw.close();
    }

}

