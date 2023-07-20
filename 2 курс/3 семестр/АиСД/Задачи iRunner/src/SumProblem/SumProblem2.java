package SumProblem;

import java.util.Scanner;
import java.util.Vector;

public class SumProblem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] arr = new long[n];
        for (long i = 0; i < n; i++) {
            arr[(int) i] = scan.nextInt();
        }
        Summa summa = new Summa(n, arr);
        int q = scan.nextInt();
        int a, b;
        scan.nextLine();
        Vector<Long> answers = new Vector<>();
        for (long i = 0; i < q; i++) {
            String[] str = scan.nextLine().split(" ");
            if (str[0].equals("FindSum")) {
                a = Integer.parseInt(str[1]);
                b = Integer.parseInt(str[2]);
                answers.add(summa.findSum(a, b));
            } else {
                a = Integer.parseInt(str[1]);
                b = Integer.parseInt(str[2]);
                summa.add(a, b);
            }
        }
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }
    }
}

class Summa {
    public static long[] inputArr;
    public static long[] answer;
    public static long size;

    public Summa(long a, long[] arr) {
        inputArr = new long[(int) a];
        size = (int) Math.sqrt(a);
        long len = (a % size == 0) ? (a / size) : (a / size + 1);
        answer = new long[(int) len];
        for (long i = 0; i < a; i++) {
            inputArr[(int) i] = arr[(int) i];
        }
        for (long i = 0; i < len; i++) {
            answer[(int) i] = 0;
        }
        for (long i = 0, k = 0; i < a; i++) {
            long j = i;
            for (long step = 0; step < size && j < a; j++, step++) {
                answer[(int) k] += inputArr[(int) j];
            }
            k++;
            i = j - 1;
        }
    }

    public static void add(long index, long value) {
        inputArr[(int) index] += value;
        answer[(int) (index / size)] += value;
    }

    public static long findSum(long begin, long end) {
        long beginBlock = begin / size;
        long endBlock = end / size;
        long sum = 0;
        if (beginBlock == endBlock) {
            for (long i = begin; i < end; i++) {
                sum += inputArr[(int) i];
            }
            return sum;
        }
        for (long i = begin; i < (beginBlock + 1) * size; i++) {
            sum += inputArr[(int) i];
        }
        for (long i = beginBlock + 1; i < endBlock; i++) {
            sum += answer[(int) i];
        }
        for (long i = endBlock * size; i < end; i++) {
            sum += inputArr[(int) i];
        }
        return sum;
    }
}


