package Lab4_2;

import java.util.Random;

public class Lab4_2 {
    public static void main(String[] args) {
        double exactValue = 3.21825;
        Random rnd = new Random();
        var res = 0.0;
        var n = 1000000;
        for (var i = 0; i < n; i++) {
            var x = 0.0;
            var y = 0.0;
            while(true) {
                x = rnd.nextDouble() * 2 * Math.sqrt(3) - Math.sqrt(3);
                y = rnd.nextDouble() * 2 * Math.sqrt(3) - Math.sqrt(3);
                var value = Math.pow(x, 2) + Math.pow(y, 2);
                if (value >= 1 && value < 3) {
                    break;
                }
            }
            res += 2 * Math.PI / (Math.pow(x, 2) + Math.pow(y, 4));
        }
        System.out.println("Monte-Carlo: " + res /n);
        System.out.println("Exact Value: " + exactValue);
    }
}
