package TheIntersectingRoad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TheIntersectingRoad {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        Scanner sc = new Scanner(br);
        long n = sc.nextInt();
        long m = sc.nextInt();
        long start = sc.nextInt();
        long end = sc.nextInt();
        ArrayList<Edge>[] edges = new ArrayList[(int) n];
        long u, v, w;
        Comparator comp = new Comparator();
        for (long i = 0; i < m; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            edges[(int) (u - 1)].add(new Edge(v - 1, w));
            edges[(int) (v - 1)].add(new Edge(u - 1, w));
        }
        long[] isVisited = new long[(int) n];
        long[] distances = new long[(int) n];
        for (int i = 0; i < n; i++)
        {
            isVisited[i] = -1;
            distances[i] = Long.MAX_VALUE;
        }
        PriorityQueue<QueueElement> s = new PriorityQueue<>(); //, ArrayList<QueueElement>, Comparator
        s.add(new QueueElement(start - 1, 0, -2));
        QueueElement top = new QueueElement();
        while (!s.isEmpty())
        {
            top = s.peek();
            s.poll();
            if (isVisited[(int) top.vertex] != -1)
                continue;
            isVisited[(int) top.vertex] = top.pred;
            distances[(int) top.vertex] = top.w;
            for (int i = 0; i < edges.length; i++)
            {
                if (isVisited[(int) edges[(int) top.vertex].get(i).end] == -1 &&
                        top.w + edges[(int) top.vertex].get(i).weight +
                        edges[(int) edges[(int) top.vertex].get(i).end].size() <
                        distances[(int) edges[(int) top.vertex].get(i).end])
                        s.add(new QueueElement(edges[(int) top.vertex].get(i).end, top.w +
                        edges[(int) top.vertex].get(i).weight +
                        edges[(int) edges[(int) top.vertex].get(i).end].size(), top.vertex));
            }
            fw.write((int) (distances[(int) (end - 1)] - edges[(int) (end - 1)].size()));
            ArrayList<Long> path = new ArrayList<>();
            long vertex = end - 1;
            while (vertex != -2) {
                path.add(vertex);
                vertex = isVisited[(int) vertex];
            }
            for (int i = path.size() - 1; i >= 0; i--) {
                fw.write((path.get(i) + 1) + "\n");
            }
        }
    }
}
class Edge {
    long end;
    long weight;
    Edge(long iEnd, long iWeight) {
        this.end = iEnd;
        this.weight = iWeight;
    }
}

class QueueElement {
    long w;
    long vertex;
    long pred;
    QueueElement() {
        this.w = 0;
        this.vertex = 0;
        this.pred = -1;
    }
    QueueElement(long iVertex, long iDistance, long iPred) {
        this.vertex = iVertex;
        this.w = iDistance;
        this.pred = iPred;
    }
}

class Comparator {
    public boolean operator(QueueElement a, QueueElement b) {
        return a.w > b.w;
    };
};
