package Roads;

import java.io.*;

public class Roads01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        int count;
        String[] str = br.readLine().split(" ");
        Road dsu = new Road(Integer.parseInt(str[0]));
        count = Integer.parseInt(str[1]);
        for (int i = 0; i < count; i++) {
            str = br.readLine().split(" ");
            dsu.unification(Integer.parseInt(str[0]) - 1, Integer.parseInt(str[1]) - 1);
            fw.write(String.valueOf(dsu.record) + '\n');
        }
        fw.close();
    }
}

@SuppressWarnings("ALL")
class Road {
    public int[] parents;
    public int[] quantity;
    public int record;

    public Road(int size) {
        record = size;
        parents = new int[size];
        quantity = new int[size];
        for (int i = 0; i < size; i++) {
            parents[i] = i;
            quantity[i] = 1;
        }
    }

    int findSet(int value) {
        if (parents[value] == value) {
            return value;
        }
        parents[value] = findSet(parents[value]);
        return parents[value];
    }

    public void unification(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        if (x != y) {
            if (quantity[x] < quantity[y]) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            parents[y] = x;
            quantity[x] += quantity[y];
            record--;
        }
    }
}
