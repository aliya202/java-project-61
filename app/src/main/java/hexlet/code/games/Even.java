package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    private static String[][] getEven() {
        final String[][] values = new String[Engine.ROUNDS][Engine.RESULTS];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int randomNumber = Utils.getRandom();
            values[i][0] = String.valueOf(randomNumber);
            values[i][1] = getResult(randomNumber) ? "yes" : "no";
        }
        return values;
    }


    public static void run() {
        Engine.run("Answer 'yes' if the number is even, otherwise answer 'no'.", getEven());
    }

    public static boolean getResult(int randomNumber) {
        return randomNumber % 2 == 0;
    }
}
