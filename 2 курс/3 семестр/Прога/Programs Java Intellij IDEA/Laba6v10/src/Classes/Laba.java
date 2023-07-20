package Classes;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Laba {
    public static Worker[] createCompany() {
        Worker[] firm = new Worker[5];
        firm[0] = new Manager(AppLocale.getString(AppLocale.valera));
        firm[0].setInfo(AppLocale.getString(AppLocale.manager));
        firm[0].setInfo(AppLocale.getString(AppLocale.the_main_person));

        firm[1] = new Analyst(AppLocale.getString(AppLocale.vlad));
        firm[1].setInfo(AppLocale.getString(AppLocale.analyst));
        firm[1].setInfo(AppLocale.getString(AppLocale.analyst_of_our_finance));

        firm[2] = new Programmer(AppLocale.getString(AppLocale.ivan));
        firm[2].setInfo(AppLocale.getString(AppLocale.programmer));
        firm[2].setInfo(AppLocale.getString(AppLocale.koder_in_java));

        firm[3] = new Tester(AppLocale.getString(AppLocale.liza));
        firm[3].setInfo(AppLocale.getString(AppLocale.tester));
        firm[3].setInfo(AppLocale.getString(AppLocale.testers_all_programms));

        firm[4] = new Designer(AppLocale.getString(AppLocale.kirill));
        firm[4].setInfo(AppLocale.getString(AppLocale.designer));
        firm[4].setInfo(AppLocale.getString(AppLocale.designs_our_programms));

        return firm;
    }

    static Locale createLocale(String[] args) {
        if (args.length == 2) {
            return new Locale(args[0], args[1]);
        } else if (args.length == 4) {
            return new Locale(args[2], args[3]);
        }
        return null;
    }

    static void setupConsole(String[] args) {
        if (args.length >= 2) {
            if (args[0].compareTo("-encoding") == 0) {
                try {
                    PrintStream outStream = new PrintStream(System.out, true, "UTF-8");
                    System.setOut(outStream);
                } catch (UnsupportedEncodingException ex) {
                    System.err.println("Unsupported encoding: " + args[1]);
                    System.exit(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            //Locale loc = createLocale(args);
            //Locale loc = new Locale("ru", "RU");

            setupConsole(args);
            if (args.length == 0) {
                Locale loc = createLocale(new String[]{"ru", "Ru"});
                AppLocale.set(loc);
            } else {
                Locale loc = createLocale(args);
                AppLocale.set(loc);
            }

            Connector con = new Connector("firm.dat");
            con.write(createCompany());
            Worker[] firm = con.read();
            System.out.println(AppLocale.getString(AppLocale.the_firm) + ":");
            for (Worker n : firm) {
                System.out.println(n);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

