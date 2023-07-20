package Laba1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if ( args.length != 2 ) {
            System.err.println("Invalid number of arguments");
            System.exit(1);
        }
        //Scanner scan = new Scanner(System.in);
        double x = Double.parseDouble( args[0] );
        //System.out.println("Введите x: ");
        //double x = Double.parseDouble( scan.nextLine() );
        if ( x > 1 || x < -1 ) {
            System.err.println("Invalid argument: " + x );
            System.exit(1);
        }
        int k = Integer.parseInt( args[1] );
        //System.out.println("Введите k: ");
        //int k = Integer.parseInt( scan.nextLine() );
        if ( k <= 1 ) {
            System.err.println("Invalid argument: " + k );
            System.exit(1);
        }
        double Eps = 1 / Math.pow( 10, k + 1 );
        double result = 0;
        double step = x;
        int n = 1;
        while( Math.abs( result ) < Eps ) {
            result += step;
            step = (x + (x * x / ((n + 1) * (n + 2))));
            n++;
        }
        System.out.println("Свое вычисление: " + roundAvoid(step, k));
        System.out.println("Вычисление с Math: " + roundAvoid(Math.asin(x + (x * x / ((n + 1) * (n + 2)))), k ));
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
