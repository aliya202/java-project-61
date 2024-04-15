package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {

    private static String[][] generate() {
        final String[][] values = new String[Engine.ROUNDS][1];

        for (int i = 0; i < values.length; i++) {
            int randomNumber = Utils.getRandom();
            values[i][0] = String.valueOf(randomNumber);
        }
        return values;
    }

    private static String[][] transform() {
        String[][] generate = generate();
        int rounds = generate.length;
        String[][] transformed = Engine.ROUNDS_DATA;

        for (int i = 0; i < rounds; i++) {
            String answer = isPrime(Integer.parseInt(generate[i][0])) ? "yes" : "no";

            transformed[i][0] = generate[i][0];
            transformed[i][1] = answer;
        }
        return transformed;
    }

    public static void run() {
        Engine.run("Answer 'yes' if given number is prime. Otherwise answer 'no'.",
                transform());
    }

    private static boolean isPrime(int randomNumber) {
        if (randomNumber < 2) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(randomNumber); i++) {
            if (randomNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
