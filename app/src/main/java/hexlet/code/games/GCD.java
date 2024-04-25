package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {

    private static String[][] getGCD() {
        final String[][] values = new String[Engine.ROUNDS][Engine.RESULTS];
        for (int i = 0; i < values.length; i++) {
            int num1 = Utils.getRandom();
            int num2 = Utils.getRandom();

            String answer = String.valueOf(getResult(num1, num2));
            values[i][0] = num1 + " " + num2;
            values[i][1] = answer;
        }
        return values;
    }

    public static int getResult(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static void run() {
        Engine.run("Find the greatest common divisor of given numbers.", getGCD());
    }
}
