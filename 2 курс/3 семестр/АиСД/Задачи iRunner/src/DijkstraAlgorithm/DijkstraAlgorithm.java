package DijkstraAlgorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DijkstraAlgorithm {
    static int i, j, n, p, xn, xk, m;
    static boolean[] flag = new boolean[11];
    static int[][] c = new int[11][11];
    static int[] l = new int[11];

    static int min(int n) {
        int i, result = 0;
        for (i = 0; i < n; i++)
            if (!(flag[i])) result = i;
        for (i = 0; i < n; i++)
            if ((l[result] > l[i]) && (!flag[i])) result = i;
        return result;
    }

    static int minim(int x, int y) {
        return Math.min(x, y);
    }

    public static void main(String[] args) throws IOException {
        StringBuilder path;
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
       // System.out.println("Напишите число точек: ");
        Scanner sc = new Scanner(br);
        n = sc.nextInt();
        m = sc.nextInt();

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                c[i][j] = 0;
            }
        }
        String[] str;
        for (i = 0; i < n; i++)
            for (j = i + 1; j < n; j++) {
              // System.out.println(" задайте длины рёбер  x");
              // System.out.print(i + 1);
              // System.out.println(" do x");
              // System.out.print(j + 1);
              // System.out.print(": ");
                str = br.readLine().split(" ");
                c[i][j] = Integer.parseInt(str[1]);

            }
       // System.out.println("   ");
       // for (i = 0; i < n; i++) {
       //     System.out.println("    X");
       //     System.out.println(i + 1);
       // }
       // System.out.println("\n");
       // System.out.println("\n");

      //for (i = 0; i < n; i++) {
      //    System.out.println("X{0:D}" + i + 1);

      //    for (j = 0; j < n; j++) {
      //        System.out.println("{0,6:D}" + (c[i][j]));
      //        c[j][i] = c[i][j];
      //    }
      //    System.out.println("\n\n");

      //}
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (c[i][j] == 0) {
                    c[i][j] = 65535;
                }
            }
        }
        System.out.println(" задайте начальную точку: ");
        xn = sc.nextInt();
        path = new StringBuilder((xn + " "));
        System.out.println(" задайте конечную точку: ");
        xk = sc.nextInt();
        int rem = xk;
        xk--;
        xn--;
        if (xn == xk) {
            System.out.println("Начальная и конечные точки совпадают");
            sc.nextInt();
            return;
        }

        for (i = 0; i < n; i++) {
            flag[i] = false;
            l[i] = 65535;
        }
        l[xn] = 0;
        flag[xn] = true;
        p = xn;

        //s = String.valueOf(xn + 1);
        //for (i = 1; i <= n; i++) {
        //    //path[i] = Convert.ToSByte("X");
        //    //path[i] +=Convert.ToSByte(s);
        //}
        do {
            for (i = 0; i < n; i++) {
                if ((c[p][i] != 65535) && (!flag[i]) && (i != p)) {
                   // if (l[i] > l[p] + c[p][i]) {
                    //    s = String.valueOf(i + 1);
                   // }
                    l[i] = minim(l[i], l[p] + c[p][i]);
                }
            }
            p = min(n);
            path.append(n);
            flag[p] = true;
        }
        while (p != xk);

        if (l[p] != 65535) {
            path.append(rem);
            System.out.println("Put: ");
            System.out.println(path);
            System.out.println("\n");
            System.out.println("Dlina puti: ");
            System.out.println(l[p]);
            System.out.println("\n");
        } else {
            System.out.println("Путь не существует!");
        }
        System.out.println("\n");
    }
}
