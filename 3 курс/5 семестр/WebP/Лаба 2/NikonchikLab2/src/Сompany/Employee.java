package Сompany;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The abstract class Employee
 * @author Nikonchik Daniil
 * @version 1.0 20.09.2021
 */
public abstract class Employee {
    /**
     * public String FullName
     */
    private String fullName;

    /**
     * public int Experience
     */
    public int experience;

    /**
     * public double Salary
     */
    public double salary;

    /**
     * public double BonusAmount
     */
    public double bonusAmount;

    /**
     * public String Position
     */
    public String position;

    /**
     * Constructor Employee
     * @param name - string param
     * @param experience - int param
     * @param salary - double param
     */
    public Employee(String name, int experience, double salary) {
        this.fullName = name;
        this.experience = experience;
        this.salary = salary;
    }

    /**
     * Getter for FullName
     * @return - FullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Getter for Experience
     * @return - Experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Getter for Salary
     * @return - Salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Getter for BonusAmount
     * @return - BonusAmount
     */
    public double getBonusAmount() {
        return bonusAmount;
    }

    /**
     * Getter for Position
     * @return - Position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Setter for FullName
     * @param fullName - string param
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Setter for Experience
     * @param experience - int param
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Setter for Salary
     * @param salary - double param
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Setter for FullName
     * @param bonusAmount - double param
     */
    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    /**
     * Setter fo Position
     * @param position - string param
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Abstract method AllPayments
     * @return what will be in the override
     */
    public abstract double allPayments();

    /**
     * Abstract method GetPremium
     * @return what will be in the override
     */
    public abstract double getPremium();

    @Override
    public String toString() {
        return "Employee's name: " + fullName + ";" +
                " Position: " + position + ";" +
                " Experience: " + experience + ";" +
                " Salary: " + salary + ";" +
                " Premium: " + getPremium() + ";" +
                " Total to be paid: " + allPayments();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return experience == employee.experience &&
                Double.compare(employee.salary, salary) == 0 &&
                Double.compare(employee.bonusAmount, bonusAmount) == 0 &&
                Objects.equals(fullName, employee.fullName) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, experience, salary, bonusAmount, position);
    }
}
