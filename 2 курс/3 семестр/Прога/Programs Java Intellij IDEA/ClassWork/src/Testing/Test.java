package Testing;

public class Test {
    public Test() {
    }
    public static void main(String[] args) {
        printTest();
    }
    public static void test1() {
        int a = 1;
        int b = 2;
        int sum = a + b;
        System.out.println("Test1: sum: " + sum);
    }
    public static void test2() {
        int x = (int) (Math.random() * 100);
        System.out.println("Test2: " + x);
    }
    public static void test3() {
        int a = 2;
        int b = 3;
        if (a != b) {
            System.err.println("Test3: err");
        }
    }
    public static void printTest() {
        test3();
        test2();
        test1();
    }
}
