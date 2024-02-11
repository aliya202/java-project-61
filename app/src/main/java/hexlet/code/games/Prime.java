package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static void runGame() {
        String[][] roundsData = new String[3][2];
        for (int i = 0; i < 3; i++) {
            int randomNumber = (int) (Math.random() * 100);
            roundsData[i][0] = String.valueOf(randomNumber);

            String result = isPrime(randomNumber) ? "yes" : "no";
            roundsData[i][1] = result;
        }
        Engine.run("Answer 'yes' if the number is prime, otherwise answer 'no'.", roundsData);
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
