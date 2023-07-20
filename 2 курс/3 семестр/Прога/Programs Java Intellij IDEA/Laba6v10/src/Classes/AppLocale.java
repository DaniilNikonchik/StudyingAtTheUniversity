package Classes;

import java.util.*;

public class AppLocale {
    private static final String strMsg = "Msg";
    private static Locale loc = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle(AppLocale.strMsg, AppLocale.loc);

    static Locale get() {
        return AppLocale.loc;
    }

    static void set(Locale loc) {
        AppLocale.loc = loc;
        res = ResourceBundle.getBundle(AppLocale.strMsg, AppLocale.loc);
    }

    static ResourceBundle getBundle() { return AppLocale.res; }

    static String getString(String key) {
        return AppLocale.res.getString(key);
    }

    public static final String worker = "worker";
    public static final String type = "type";
    public static final String info = "info";
    public static final String creation = "creation";
    public static final String valera = "valera";
    public static final String the_main_person = "the_main_person";
    public static final String vlad = "vlad";
    public static final String analyst_of_our_finance = "analyst_of_our_finance";
    public static final String ivan = "ivan";
    public static final String koder_in_java = "koder_in_java";
    public static final String liza = "liza";
    public static final String testers_all_programms = "testers_all_programms";
    public static final String kirill = "kirill";
    public static final String designs_our_programms = "designs_our_programms";
    public static final String the_firm = "the_firm";
    public static final String manager = "manager";
    public static final String programmer = "programmer";
    public static final String analyst = "analyst";
    public static final String tester = "tester";
    public static final String designer = "designer";
}