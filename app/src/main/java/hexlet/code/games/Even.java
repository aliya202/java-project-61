package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_DATA;

public class Even {

    public static void runGame() {
        String[][] roundsData = ROUNDS_DATA;
        for (int i = 0; i < roundsData.length; i++) {
            int randomNumber = Utils.getRandom();
            roundsData[i][0] = String.valueOf(randomNumber);

            String result = isEven(randomNumber) ? "yes" : "no";
            roundsData[i][1] = result;
        }
        Engine.run("Answer 'yes' if the number is even, otherwise answer 'no'.", roundsData);
    }

    public static boolean isEven(int randomNumber) {
        return randomNumber % 2 == 0;
    }
}
