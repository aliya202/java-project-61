package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {

    private static String[][] getPrime() {
        final String[][] values = new String[Engine.ROUNDS][Engine.RESULTS];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int randomNumber = Utils.getRandom();
            values[i][0] = String.valueOf(randomNumber);
            values[i][1] = getResult(randomNumber) ? "yes" : "no";
        }
        return values;
    }

    private static boolean getResult(int randomNumber) {
        if (randomNumber < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(randomNumber); i++) {
            if (randomNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void run() {
        Engine.run("Answer 'yes' if given number is prime. Otherwise answer 'no'.",
                getPrime());
    }
}
