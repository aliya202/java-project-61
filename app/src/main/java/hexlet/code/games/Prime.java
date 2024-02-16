package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_DATA;

public class Prime {

    public static void runGame() {

        for (int i = 0; i < ROUNDS_DATA.length; i++) {
            int randomNumber = Utils.getRandom();
            ROUNDS_DATA[i][0] = String.valueOf(randomNumber);

            String result = isPrime(randomNumber) ? "yes" : "no";
            ROUNDS_DATA[i][1] = result;
        }
        Engine.run("Answer 'yes' if given number is prime. Otherwise answer 'no'.", ROUNDS_DATA);
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
