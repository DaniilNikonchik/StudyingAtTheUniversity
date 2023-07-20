package Сompany;

/**
 * The class Workers heir Employee
 * @author Nikonchik Daniil
 * @version 1.0 20.09.2021
 */
public class Workers extends Employee {

    /**
     * Constructor Workers
     * @param name - string param
     * @param experience - int param
     * @param salary - double param
     * @param position - string param
     */
    public Workers(String name, int experience, double salary, String position) {
        super(name, experience, salary);
        this.position = position;
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
