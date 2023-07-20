package Lab1;

import java.util.Arrays;

public class Lab1 {
    public static void main(String[] args) {
        double[] firstSeq = new double[NumImplements];
        double[] secondSeq = new double[K];
        double[] thirdSeq = new double[NumImplements];
        MultiMethod(firstSeq, A0, NumImplements);
        MultiMethod(secondSeq, 2 * Beta + 1, K);
        MethodMacLarenMarsaglia(thirdSeq, secondSeq, firstSeq);
        TestPirson(firstSeq, 10);
        TestPirson(thirdSeq, 5);
        TestKolmogorov(firstSeq);
        TestKolmogorov(thirdSeq);
    }

    public static long A0 = 65643;
    public static long Beta = A0;
    public static long M = 2147483648L;
    public static int NumImplements = 1000;
    public static int K = 256;
    public static double CriticalNum = 16.91898;
    public static double CriticalNumD = 1.63;

    public static void MultiMethod(double[] a, long beta, int n) {
        double[] aWithStar = new double[n];
        aWithStar[0] = beta * beta % M;
        a[0] = aWithStar[0] / M;

        for (int i = 1; i < n; i++) {
            aWithStar[i] = aWithStar[i - 1] * Beta % M;
            a[i] = aWithStar[i] / M;
        }
    }

    public static void MethodMacLarenMarsaglia(double[] a, double[] b, double[] c) {
        double[] temp = Arrays.copyOf(b, K);

        for (int i = 0; i < NumImplements; i++) {
            int s = ((int) (c[i] * K)) % K;
            a[i] = temp[s];
            temp[s] = c[(i + K) % K];
        }

    }

    public static void TestPirson(double[] a, int L) { // по формуле
        Arrays.sort(a);
        double xi = 0;
        var i = 0;

        for (int j = 1; j <= L; j++) {
            var count = 0;
            while ((i < NumImplements) && (a[i] < (double) j / L)) {
                i++;
                count++;
            }
            xi += Math.pow(count - (double) (NumImplements / L), 2);
        }

        System.out.println("xi^2 = " + xi / (double) (NumImplements / L) + " | critical number: " + CriticalNum);
    }

    public static void TestKolmogorov(double[] a) {
        Arrays.sort(a);
        double D = 0;

        for (int i = 0; i < NumImplements; i++) {
            D = Math.max(D, Math.abs(((double) i + 1) / NumImplements) - a[i]);
        }

        System.out.println("D = " + D * Math.sqrt(1000) + " | critical number: " + CriticalNumD);
    }
}
