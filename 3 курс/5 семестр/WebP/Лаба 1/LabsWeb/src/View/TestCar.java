package View;

import Vehicle.Car;

/**
 * Test class for demonstration
 *
 * @author Nikonchik Daniil
 * @version 1.0
 */
public class TestCar {

    /**
     * The main method
     * @param args command line options
     */
    public static void main(String[] args) {
        String model = "BMW";
        Car car = new Car(model);
        System.out.println("Модель = " + car.getModel());
        car.move();
        car.fillUp(10);
        car.replaceTheWheel(1);
        car.stop();
        car.fillUp(10);
        car.replaceTheWheel(1);

    }
}
