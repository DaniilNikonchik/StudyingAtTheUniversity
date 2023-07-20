package TheConfluenceOfIncreasingSequences;

import java.io.*;
import java.util.*;

public class TCOIS1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mult = m * n;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < mult; i++) {
            int t = sc.nextInt();
            if (q.isEmpty()) {
                q.add(t);
            } else if (t > q.getFirst() && t > q.getLast()) {
                q.addLast(t);
            } else if (t < q.getLast() && t > q.getFirst()) {
                q.add(q.size()/2, t);
            }
        }
        for (int i = 0; i < mult - 1; i++) {
            fw.write(q.get(i) + " ");
        }
        fw.write(String.valueOf(q.getLast()));
        fw.close();
    }
}
/*
#include <fstream>
#include <queue>
using namespace std;
int main() {
ifstream in("input.txt") ;
ofstream out("output.txt");
int n, m, len, k;
in»n»m;
len=n*m;
priority_queue q;
while (len--) in»k, q.push(-k);
for(int i = 1;i<n*m;i++){
out«-q.top()«" ";
q.pop();
}
out«-q.top();
}
 */

