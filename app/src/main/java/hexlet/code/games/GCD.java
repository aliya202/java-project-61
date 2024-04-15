package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {

    private static String[][] transform() {
        final String[][] values = new String[Engine.ROUNDS][2];
        String[][] transformed = Engine.ROUNDS_DATA;
        for (int i = 0; i < values.length; i++) {
            int num1 = Utils.getRandom();
            int num2 = Utils.getRandom();

            String answer = String.valueOf(findGCD(num1, num2));
            transformed[i][0] = num1 + " " + num2;
            transformed[i][1] = answer;
        }
        return transformed;
    }

    public static void run() {
        Engine.run("Find the greatest common divisor of given numbers.", transform());
    }

    public static int findGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}
