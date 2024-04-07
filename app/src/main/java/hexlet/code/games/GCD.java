package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {

    private static String[][] generate() {
        final String[][] values = new String[Engine.ROUNDS][2];

        for (int i = 0; i < values.length; i++) {
            int num1 = Utils.getRandom();
            int num2 = Utils.getRandom();

            values[i][0] = String.valueOf(num1);
            values[i][1] = String.valueOf(num2);
        }

        return values;
    }

    private static String[][] transform() {
        String[][] generate = generate();
        String[][] transformed = Engine.ROUNDS_DATA;
        int rounds = generate.length;

        for (int i = 0; i < rounds; i++) {
            String answer = String.valueOf(findGCD(Integer.parseInt(generate[i][0]),
                    Integer.parseInt(generate[i][1])));
            transformed[i][0] = generate[i][0] + " " + generate[i][1];
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
