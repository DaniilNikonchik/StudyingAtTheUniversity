package Laba3;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(1, 2, 3);
        Vector vector2 = new Vector(1, 2, 3);
        Vector vector3 = new Vector(1, 2, 3);
        Vector[] arr = new Vector[] {
                new Vector(1, 2, 3),
                new Vector(1, 2, 3),
                new Vector(1, 2, 3),
                new Vector(1, 2, 3),
                new Vector(1, 2, 3)
        };

        System.out.println("The first vector plus the second:");
        Vector vec1 = vector1.amount(vector2);
        System.out.println(vec1);

        System.out.println("The first vector divided by the second:");
        Vector vec2 = vector1.difference(vector2);
        System.out.println(vec2);

        System.out.println("The first vector multiplied by a number:");
        Vector vec3 = vector1.multiplication(4);
        System.out.println(vec3);

        System.out.println("The second vector multiplied by a number:");
        Vector vec4 = vector2.multiplication(4);
        System.out.println(vec4);

        System.out.println("The comparison of vectors:");
        vector1.comparison(vector2);
        System.out.println("");

        System.out.println("Coplanarity of vectors: ");
        //vector1.coplanar(vector2, vector3);
        Vector n;
        for (int i = 0; i < arr.length; i++) {
            n = arr[i];
            n.coplanar(n, n);
        }
    }
}
