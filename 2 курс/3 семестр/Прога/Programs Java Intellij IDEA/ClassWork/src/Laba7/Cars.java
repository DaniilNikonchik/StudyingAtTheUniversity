package Laba7;

import java.io.*;
import java.util.*;

public class Cars {
    public static void main(String[] args) {
        try {
            if (args.length >= 1) {
                if (args[0].compareTo("-a") == 0) {
                    // Append file with new object from System.in
                    appendFile();
                } else if (args[0].compareTo("-p") == 0) {
                    // Prints data file
                    printFile();
                } else if (args[0].compareTo("-d") == 0) {
                    // Delete data file
                    deleteFile();
                } else {
                    System.err.println("Option is not realised: " + args[0]);
                    System.exit(1);
                }
            } else {
                System.err.println("Cars: Nothing to do!");
            }
        } catch (Exception e) {
            System.err.println("Runtime error: " + e);
            System.exit(1);
        }
        System.out.println("Cars finished...");
        System.exit(0);
    }

    static final String filename = "Cars.dat";

    private static Scanner fin = new Scanner(System.in);

    static Car read() {
        System.out.println("Write \"Exit\" to end data input");
        if (fin.hasNextLine()) {
            return Car.read(fin);
        }
        return null;
    }

    static void deleteFile() {
        File f = new File(filename);
        f.delete();
    }

    static void appendFile() throws IOException {
        Car car;
        System.out.println("Enter car data: ");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            while ((car = read()) != null) {
                Buffer.writeObject(raf, car);
            }
        }
    }

    static void printFile() throws IOException, ClassNotFoundException {
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            long pos;
            while ((pos = raf.getFilePointer()) < raf.length()) {
                Car car = (Car) Buffer.readObject(raf, pos);
                System.out.println(pos + ": " + car);
            }
        }
    }
}
