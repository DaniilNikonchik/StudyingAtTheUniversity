package Testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Password {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner log = new Scanner(new File("login.txt"));
        Scanner pass = new Scanner(new File("password.txt"));
        Scanner systemIn = new Scanner(System.in);
        int tries = 3;

        while (log.hasNextLine()) {
            System.out.println("Enter login: ");
            String searchLogin = systemIn.nextLine();
            String dataLog = log.nextLine();
            System.out.println("Enter password: ");
            String searchPassword = systemIn.nextLine();
            String dataPassword = pass.nextLine();
            if (!dataLog.equals(searchLogin) || !dataPassword.equals(searchPassword)) {
                System.out.println("Not found. " + tries + " tries test.");
                tries++;
                if (tries == 0) {
                    break;
                }
            }
        }
    }
}
