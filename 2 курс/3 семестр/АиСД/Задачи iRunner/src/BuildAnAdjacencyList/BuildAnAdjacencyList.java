package BuildAnAdjacencyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BuildAnAdjacencyList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        ArrayList[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        int u, v;
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            u = Integer.parseInt(str[0]);
            v = Integer.parseInt(str[1]);
            list[u - 1].add(v);
            list[v - 1].add(u);
        }
        for (int i = 0; i < n; i++) {
            fw.write(list[i].size() + " ");
            for (Object j : list[i]) {
                fw.write(j + " ");
            }
            fw.write("\n");
        }
        fw.close();
    }
}