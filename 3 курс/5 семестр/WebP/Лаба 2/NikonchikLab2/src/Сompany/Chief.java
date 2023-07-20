package Сompany;

/**
 * The class Chief heir Employee
 * @author Nikonchik Daniil
 * @version 1.0 20.09.2021
 */
public class Chief extends Employee {
    /**
     * Constructor Chief
     * @param name - string param
     * @param experience - int param
     * @param salary - double param
     */
    public Chief(String name, int experience, double salary) {
        super(name, experience, salary);
        position = "Начальник";
    }

    @Override
    public double allPayments() {
        return salary * bonusAmount + salary;
    }

    @Override
    public double getPremium() {
        if (experience < 20) {
            if (experience < 10)
                bonusAmount = 0.2;
            if (experience >= 10)
                bonusAmount = 0.4;
        } else
            bonusAmount = 0.6;
        return bonusAmount * salary;
    }
}
