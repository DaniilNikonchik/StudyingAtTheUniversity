package Passwords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class passwords {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        Scanner output = new Scanner(new File("output.txt"));
        Scanner systemIn = new Scanner(System.in);
        int tries = 3;

        while (input.hasNextLine()) {
            System.out.println("Enter login: ");
            String searchLog = systemIn.nextLine();
            System.out.println("Enter password: ");
            String searchPass = systemIn.nextLine();

            String dataLog = input.nextLine();
            String dataPass = output.nextLine();

            if (!dataLog.equals(searchLog) || !dataPass.equals(searchPass)) {
                System.out.println("Not found. " + tries + " tries test.");
                tries++;
                if (tries == 0) {
                    break;
                }
            }

        }

    }
}
