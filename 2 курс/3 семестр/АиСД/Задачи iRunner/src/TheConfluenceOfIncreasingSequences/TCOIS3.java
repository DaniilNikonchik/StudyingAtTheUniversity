package TheConfluenceOfIncreasingSequences;

import java.io.*;
import java.util.*;

public class TCOIS3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mult = m * n;
        PriorityQueue<Integer> q = new PriorityQueue<>(m);
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            q.add(t);
        }
        for (int i = 1; i < mult; i++) {
            fw.write(q.element() + " ");
            q.poll();
        }
        fw.write(String.valueOf(q.element()));
        fw.close();
    }
}