package View;

import Sorting.SortedByWorkExperience;
import Сompany.Department;
import Сompany.Workers;

/**
 * The Test class for view
 * @author Nikonchik Daniil
 * @version 1.0 20.09.2021
 */
public class Test {

    /**
     * Main methods
     * @param args - string param
     */
    public static void main(String[] args) {
        Department economy = new Department("Economic Department", "Petrova Luda", 15, 1200.0);
        economy.Add(new Workers("Ivanov Petr", 15, 800.0, "Lead Economist"));
        System.out.println("Department name: " + economy.DepartmentName);
        System.out.println(economy.Boss);

        for (var worker : economy.Staff) {
            System.out.println(worker);
        }

        Department pto = new Department("PTO", "Moroz Vasiliy", 25, 1500.0);
        pto.Add(new Workers("Sidorov Semion", 20, 900.0, "Lead Engineer"));
        System.out.println();
        System.out.println("Department name: " + pto.DepartmentName);
        System.out.println(economy.Boss);

        for (var worker : pto.Staff) {
            System.out.println(worker);
        }

        System.out.println();
        
        System.out.println("Sorting employees by seniority: " );
        SortedByWorkExperience sorted = new SortedByWorkExperience();
        sorted.compare(pto.Staff.get(0), economy.Staff.get(0));
        System.out.println(pto.Staff.get(0));
        System.out.println(economy.Staff.get(0));
        System.out.println();

    }
}
