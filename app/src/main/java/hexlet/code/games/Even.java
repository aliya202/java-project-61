package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    private static String[][] generate() {
        final String[][] values = new String[Engine.ROUNDS][2];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int randomNumber = Utils.getRandom();
            values[i][0] = String.valueOf(randomNumber);
        }
        return values;
    }

    private static String[][] transform() {
        String[][] generate = generate();
        String[][] transformed = Engine.ROUNDS_DATA;
        for (int i = 0; i < generate.length; i++) {
            String answer = isEven(Integer.parseInt(generate[i][0])) ? "yes" : "no";
            transformed[i][0] = generate[i][0];
            transformed[i][1] = answer;
        }

        return transformed;
    }

    public static void run() {
        Engine.run("Answer 'yes' if the number is even, otherwise answer 'no'.", transform());
    }

    public static boolean isEven(int randomNumber) {
        return randomNumber % 2 == 0;
    }
}
