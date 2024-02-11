package hexlet.code.games;

import java.util.Arrays;
import java.util.Random;

import hexlet.code.Engine;

public class Progression {
    private static Random random = new Random();
    public static void runGame() {
        String[][] roundsData = new String[3][2];
        for (int i = 0; i < 3; i++) {
            int length = random.nextInt(5) + 5;
            String[] progression = generateProgression(length);
            int hiddenIndex = random.nextInt(progression.length);
            String hiddenNumber = progression[hiddenIndex];
            progression[hiddenIndex] = "..";

            roundsData[i][0] = Arrays.toString(progression);
            roundsData[i][1] = hiddenNumber;
        }
        Engine.run("What number is missing in the progression?", roundsData);
    }

    private static String[] generateProgression(int length) {
        String[] progression = new String[length];
        int start = random.nextInt(50);
        int diff = random.nextInt(10) + 1;

        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * diff);
        }

        return progression;
    }
}

