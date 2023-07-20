package Sorting;

import Сompany.Employee;

import java.util.Comparator;

/**
 * SortedByWorkExperience class
 * @author Nikonchik Daniil
 * @version 1.0 20.09.2021
 */
public class SortedByWorkExperience implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        int experience2 = o1.getExperience();
        int experience1 = o2.getExperience();


        return Math.max(experience1, experience2);
    }
}
