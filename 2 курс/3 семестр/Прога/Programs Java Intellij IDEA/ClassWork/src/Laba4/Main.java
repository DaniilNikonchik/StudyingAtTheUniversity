package Laba4;

import java.util.*;

public class Main {
    public static Polynom firstPolynom;
    public static Polynom secondPolynom;

    public static void main(String[] args) {
        PolynomialParser parser = new PolynomialParser();

        //firstPolynom = parser.parse(" 32x^5 - 5x^2 + 4x + 3");
        firstPolynom = parser.parse(" 32x^5 - 5x^2 + 4x");
        secondPolynom = parser.parse(" 32x^5 - 5x^2 + 4x");
        System.out.println("First polynomial: " + firstPolynom);

        Map<Integer, Integer> members = new HashMap<>();
        members.put(5, 32);
        members.put(1, -1);
        members.put(0, 2);

        //secondPolynom = new Polynom(members);
        System.out.println("Second polynomial: " + secondPolynom);

        System.out.println("\nAddition: " + firstPolynom.add(secondPolynom));

        System.out.println("Subtraction: " + firstPolynom.subtract(secondPolynom));

        System.out.println("Amount: " + firstPolynom.multiply(secondPolynom));

        System.out.print("Comparison: ");
        if (firstPolynom.compareTo(secondPolynom) == 0) {
            System.out.print("polynomials are equal");
        } else if (firstPolynom.compareTo(secondPolynom) > 0) {
            System.out.print("the first polynomial is greater then the second");
        } else {
            System.out.print("the second polynomial is greater then the first");
        }

        System.out.println(" ");
        System.out.println(" ");

        Polynom onePolynom = parser.parse(" 32x^5");
        Polynom twoPolynom = parser.parse(" 32x^5 - 4x^4");
        Polynom threePolynom = parser.parse(" 32x^5 - 4x^4 + 5x^2");
        Polynom fourPolynom = parser.parse(" 32x^5 - 4x^4 + 5x^2 + 4x");
        Polynom fivePolynom = parser.parse(" 32x^5 - 4x^4 + 5x^2 + 4x + 2");
        ArrayList<Polynom> states = new ArrayList<>();
        states.add(onePolynom);
        states.add(twoPolynom);
        states.add(threePolynom);
        states.add(fourPolynom);
        ListIterator<Polynom> listIter = states.listIterator();
        System.out.println("List first: ");
        while (listIter.hasNext()) {
            System.out.println(listIter.next());
        }

        System.out.println("List second: ");
        listIter.set(fivePolynom);
        while (listIter.hasPrevious()) {
            System.out.println(listIter.previous());
        }
    }
}
