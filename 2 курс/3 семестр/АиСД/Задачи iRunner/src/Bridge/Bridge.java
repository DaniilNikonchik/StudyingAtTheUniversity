package Bridge;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Bridge {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 2; i < n; i++) {
            arr[i] = Math.min(arr[i] + arr[i - 1] + arr[0], arr[i] + arr[i - 2] + arr[0] + 2 * arr[1]);
        }
        fw.write(arr[n - 1]);
        fw.close();
    }
}
