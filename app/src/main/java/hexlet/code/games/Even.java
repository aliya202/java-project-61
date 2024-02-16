package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_DATA;

public class Even {

    public static void runGame() {
        for (int i = 0; i < ROUNDS_DATA.length; i++) {
            int randomNumber = Utils.getRandom();
            ROUNDS_DATA[i][0] = String.valueOf(randomNumber);

            String result = isEven(randomNumber) ? "yes" : "no";
            ROUNDS_DATA[i][1] = result;
        }
        Engine.run("Answer 'yes' if the number is even, otherwise answer 'no'.", ROUNDS_DATA);
    }

    public static boolean isEven(int randomNumber) {
        return randomNumber % 2 == 0;
    }
}
