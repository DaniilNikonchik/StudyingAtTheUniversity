package Vehicle;

/**
 * The Car class is defined using the Wheel class
 *
 * @author Nikonchik Daniil
 * @version 1.0
 */
public class Car {

    /**
     * isMove - the field of movement of the car
     */
    private boolean isMove = false;

    /**
     * model - a field that stores the name of the car
     */
    private final String model;


    /**
     * Default constructor for generating a car
     * @param model parameter for transmitting the name of the car
     */
    public Car(String model) {
        this.model = model;
    }

    /**
     * The method of stopping the car
     */
    public void stop() {
        this.isMove = false;
        System.out.println("Автомобиль остановлен.");
    }

    /**
     * The movement method
     */
    public void move() {
        this.isMove = true;
        System.out.println("Автомобиль едет.");
    }

    /**
     * The refueling method
     * @param liters parameter of the number of liters
     */
    public void fillUp(int liters) {
        if (!isMove) {
            System.out.println("Автомоболь заправлен на " + liters + " литров.");
        } else {
            System.out.println("Для заправки нужно остановить автомобиль марки: " + getModel());
        }
    }

    /**
     * The method of replacing the wheel of a car
     * @param num parameter for determining the wheel
     */
    public void replaceTheWheel(int num) {
        if (!isMove) {
            if (num >= 5) {
                System.out.println("У машины только 4 колеса.");
                }
            if (num == 0) {
                System.out.println("Номера колес начинаются с 1.");
            }
            if (num < 0) {
                System.out.println("Номера колесс не могут быть отрицательными.");
            }
            if (num >= 1 && num <= 4) {
                System.out.println("Колесо с номером " + num + " заменено.");
            }
        } else {
            System.out.println("Для замены колеса нужно остановить автомобиль марки: " + getModel());
        }
    }

    /**
     * Getter for the car model
     * @return returns the name of the car
     */
    public String getModel() {
        return this.model;
    }
}
