package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    public static void runGame() {
        String[][] roundsData = new String[3][2];
        for (int i = 0; i < 3; i++) {
            int randomNumber = (int) (Math.random() * 100);
            roundsData[i][0] = String.valueOf(randomNumber);

            boolean isEven = randomNumber % 2 == 0;
            String result = isEven ? "yes" : "no";
            roundsData[i][1] = result;
        }
        Engine.run("Answer 'yes' if the number is even, otherwise answer 'no'.", roundsData);
    }
}
