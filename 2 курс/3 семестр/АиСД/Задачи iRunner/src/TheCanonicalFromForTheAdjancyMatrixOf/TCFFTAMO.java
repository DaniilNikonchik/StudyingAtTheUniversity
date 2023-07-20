package TheCanonicalFromForTheAdjancyMatrixOf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TCFFTAMO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        {
            int i = 0;
            while (i < n) {
                String[] str = br.readLine().split(" ");
                int j = 0;
                while (j < n) {
                    if (!str[j].equals("0")) {
                        arr[j] = i + 1;
                    }
                    j++;
                }
                i++;
            }
        }
        br.close();
        int i = 0;
        while (i < n) {
            fw.write(arr[i] + " ");
            i++;
        }
        fw.close();
    }
}
