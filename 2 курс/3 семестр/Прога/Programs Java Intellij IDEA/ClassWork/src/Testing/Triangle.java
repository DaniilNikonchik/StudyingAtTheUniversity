package Testing;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, c;
        System.out.print("Enter the length of the first side: ");
        a = scan.nextInt();
        System.out.print("Enter the length of the second side: ");
        b = scan.nextInt();
        System.out.print("Enter the length of the third side: ");
        c = scan.nextInt();
        System.out.println("***************************************");
        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            System.out.println("Such a triangle exists");
        } else {
            System.out.println("There is no such triangle");
            return;
        }
        System.out.println("***************************************");
        System.out.println("Input data: " +
                "\nFirst side: " + a +
                "\nSecond side:  " + b +
                "\nThird side:  " + c);
        int perimeter = a + b + c;
        System.out.println("***************************************");
        System.out.println("Perimeter of a triangle: " + perimeter);
        System.out.println("***************************************");
        int semiPerimeter = perimeter / 2;
        int area = (int) Math.sqrt(semiPerimeter *
                (semiPerimeter - a) *
                (semiPerimeter - b) *
                (semiPerimeter - c));
        System.out.println("Area of a triangle: " + area);
        System.out.println("***************************************");
        if ((square(a) == square(b) + square(c)) ||
                (square(b) == square(a) + square(c)) ||
                (square(c) == square(b) + square(a))) {
            System.out.println("Right triangle");
        } else {
            System.out.println("The triangle is not isosceles");
        }
        System.out.println("***************************************");
        if ((a == b) && (a == c)) {
            System.out.println("Equilateral triangle");
        } else {
            System.out.println("Testing.Triangle is not equilateral");
        }

    }

    public static int square(int a) {
        return a * a;
    }
}