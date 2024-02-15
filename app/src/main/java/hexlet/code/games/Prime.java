package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_DATA;

public class Prime {

    public static void runGame() {
        String[][] roundsData = ROUNDS_DATA;

        for (int i = 0; i < roundsData.length; i++) {
            int randomNumber = Utils.getRandom();
            roundsData[i][0] = String.valueOf(randomNumber);

            String result = isPrime(randomNumber) ? "yes" : "no";
            roundsData[i][1] = result;
        }
        Engine.run("Answer 'yes' if given number is prime. Otherwise answer 'no'.", roundsData);
    }

    public static boolean isPrime(int randomNumber) {
        if (randomNumber < 2) {
            return false;
        }
        for (int i = 2; i < randomNumber / 2; i++) {
            if (randomNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
