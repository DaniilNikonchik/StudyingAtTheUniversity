package Laba7;

import java.io.Serializable;
import java.util.Scanner;

public class Car implements Serializable {
    String brand;
    String model;
    String yearOfManufacture;
    String color;
    String price;
    String registrationNumber;

    public static Car read(Scanner fin) {
        Car car = new Car();
        car.brand = fin.nextLine();
        if (car.brand.equals("Exit")) return null;
        if (!fin.hasNextLine()) return null;
        car.model = fin.nextLine();
        if (!fin.hasNextLine()) return null;
        car.yearOfManufacture = fin.nextLine();
        if (!fin.hasNextLine()) return null;
        car.color = fin.nextLine();
        if (!fin.hasNextLine()) return null;
        car.price = fin.nextLine();
        if (!fin.hasNextLine()) return null;
        car.registrationNumber = fin.nextLine();
        return car;
    }

    public Car() {}

    public String toString() {
        return new String(
                "Brand: " + brand + " | " +
                        "model: " + model + " | " +
                        "year of manufacture: " + yearOfManufacture + " | " +
                        "color: " + color + " | " +
                        "price: " + price + " | " +
                        "registration number: " + registrationNumber);
    }
}