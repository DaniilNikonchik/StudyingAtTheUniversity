package Laba9;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Scanner;


public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    String brand;
    String model;
    int year;
    String color;
    double price;
    String registrationNumber;

    static final String P_brand = "Brand";
    static final String P_model = "Model";
    static final String P_year = "Year of manufacture";
    static final String P_color = "Color";
    static final String P_price = "Price";
    static final String P_registrationNumber = "Registration number";

    static Boolean nextRead(final String prompt, Scanner fin, PrintStream out) {
        out.print(prompt);
        out.print(": ");
        return fin.hasNextLine();
    }

    public static Car read(Scanner fin, PrintStream out) throws IOException {
        String str;
        Car car = new Car();
        car.brand = fin.nextLine();

        if (!nextRead(P_model, fin, out)) return null;
        car.model = fin.nextLine();

        str = fin.nextLine();
        car.year = Integer.parseInt(str);
        if (!Laba8.Car.validYear(car.year)) {
            throw new IOException("Invalid Cars year value");
        }

        if (!nextRead(P_color, fin, out)) return null;
        car.color = fin.nextLine();

        if (!nextRead(P_price, fin, out)) return null;
        str = fin.nextLine();
        car.price = Double.parseDouble(str);

        if (!nextRead(P_registrationNumber, fin, out)) return null;
        car.registrationNumber = fin.nextLine();
        return car;
    }

    public Car() { }

    public static final String areaDel = "\n";
    public static final String del = ": ";

    public String toString() {
        return P_brand + del + brand + areaDel +
                P_model + del + model + areaDel +
                P_year + del + year + areaDel +
                P_color + del + color + areaDel +
                P_price + del + price + "$" + areaDel +
                P_registrationNumber + del + registrationNumber;
    }
}
