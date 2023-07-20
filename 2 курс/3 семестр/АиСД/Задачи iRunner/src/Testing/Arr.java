package Testing;

public class Arr {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 53, 34, 12, 67, 23, 89, 34};
        int a = 66;
        int b = 3;
        System.out.println("Checking whether there is a number " + a + " in the array: " + check(arr, a));

        System.out.println("***********************************************************************************");

        System.out.println("Checking whether there is a number " + b + " in the array: " + check(arr, b));

    }
    public static String check(int[] arr, int n) {
        for (int j : arr) {
            if (n == j) {
                return "tne number is in the array.";
            }
        }
        return "tne number is not in the array.";
    }
}
