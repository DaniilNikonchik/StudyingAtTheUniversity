package Laba8;

import java.io.*;
import java.util.*;

public class Car implements Serializable {
    // class release version:
    private static final long serialVersionUID = 1L;
    // areas with prompts:
    String brand;
    static final String P_brand = "Brand";
    String model;
    static final String P_model = "Model";
    int year;
    static final String P_year = "Year of manufacture";
    String color;
    static final String P_color = "Color";
    double price;
    static final String P_price = "Price";
    String registrationNumber;
    static final String P_registrationNumber = "Registration number";


    private static GregorianCalendar curCalendar = new GregorianCalendar();

    public static Boolean validYear(int year) {
        return year > 0 && year <= curCalendar.get(Calendar.YEAR);
    }

    public static Boolean nextRead(Scanner fin, PrintStream out) {
        return nextRead(P_brand, fin, out);
    }

    static Boolean nextRead(final String prompt, Scanner fin, PrintStream out) {
        out.print(prompt);
        out.print(": ");
        return fin.hasNextLine();
    }

    public static final String authorDel = ",";

    public static Car read(Scanner fin, PrintStream out) throws IOException {
        String str;
        Car car = new Car();
        car.brand = fin.nextLine();
        if (!nextRead(P_model, fin, out)) return null;
        car.model = fin.nextLine();
        if (!nextRead(P_year, fin, out)) return null;
        str = fin.nextLine();
        car.year = Integer.parseInt(str);
        if (!Car.validYear(car.year)) {
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
        return  P_brand + del + brand + areaDel +
                P_model + del + model + areaDel +
                P_year + del + year + areaDel +
                P_color + del +color + areaDel +
                P_price + del + price + "$" + areaDel +
                P_registrationNumber + del + registrationNumber;
    }
}
