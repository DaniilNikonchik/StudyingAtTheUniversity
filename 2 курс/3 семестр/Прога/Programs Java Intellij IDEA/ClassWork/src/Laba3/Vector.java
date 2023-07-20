package Laba3;

public class Vector {
    private int x;
    private int y;
    private int z;

    public Vector(int a, int b, int c) {
        x = a;
        y = b;
        z = c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int length() {
        return (int) Math.sqrt(x * x + y * y + z * z);
    }

    public Vector amount(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector difference(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public Vector multiplication(int alpha) {
        return new Vector(this.x * alpha, this.y * alpha, this.z * alpha);
    }

    public Vector division(int number) {
        return new Vector(this.x / number, this.y / number, this.z / number);
    }

    public void comparison(Vector other) {
        int module1 = (int) Math.sqrt(square(this.x) + square(this.y) + square(this.z));
        int module2 = (int) Math.sqrt(square(other.x) + square(other.y) + square(other.z));

        if (module1 > module2) {
            System.out.println("The first vector is larger than the second");
        }
        if (module2 > module1) {
            System.out.println("The second vector is larger than the first");
        }
        if (module1 >= module2) {
            System.out.println("The first vector is greater or equal than the second");
        }
        if (module2 >= module1) {
            System.out.println("The second vector is greater or equal than the first");
        }
        if (module2 == module1) {
            System.out.println("The vectors are equal");
        }

    }

    static int square(int a){
        return a * a;
    }

    public void coplanar(Vector first, Vector second) {
        int n = ((this.x * first.x * second.x) +
                (this.y * first.y * second.y) +
                (this.z * first.z * second.z) -
                (this.x * first.x * second.x) -
                (this.y * first.y * second.y) -
                (this.z * first.z * second.z));
        if (n == 0) {
            System.out.println("The vectors are coplanar");
        } else {
            System.out.println("the vectors are not coplanar");
        }
    }

    @Override
    public String toString() {
        return "New vector{" + "x = " + x + ", y = " + y + ", z = " + z + '}';
    }
}