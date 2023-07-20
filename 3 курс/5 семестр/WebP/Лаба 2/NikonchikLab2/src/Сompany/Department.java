package Сompany;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Department
 * @author Nikonchik Daniil
 * @version 1.0 20.09.2021
 */
public class Department {

    /**
     * public String DepartmentName
     */
    public String DepartmentName;

    /**
     * public Chief Boss
     */
    public Chief Boss;

    /**
     * public List Staff
     */
    public List<Employee> Staff;

    /**
     * Constructor Department
     * @param departmentName - string param
     * @param bossName - string param
     * @param experience - int param
     * @param salary - double param
     */
    public Department(String departmentName, String bossName, int experience, double salary) {
        DepartmentName = departmentName;
        Boss = new Chief(bossName, experience, salary);
        Staff = new ArrayList<Employee>();
    }

    /**
     * Method Add for add new workers
     * @param worker - employee param
     */
    public void Add(Employee worker) {
        Staff.add(worker);
    }
}
