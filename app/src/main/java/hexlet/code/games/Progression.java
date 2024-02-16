package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_DATA;

public class Progression {

    public static void runGame() {
        final int minLength = 5;
        final int maxLength = 10;

        for (int i = 0; i < ROUNDS_DATA.length; i++) {
            int length = Utils.getRandom(minLength, maxLength);
            String[] progression = generateProgression(length);
            int hiddenIndex = Utils.getRandom(0, length);
            String hiddenNumber = progression[hiddenIndex];
            progression[hiddenIndex] = "..";
            StringBuilder sb = new StringBuilder();

            for (String str : progression) {
                sb.append(str).append(" ");
            }
            ROUNDS_DATA[i][0] = sb.toString();
            ROUNDS_DATA[i][1] = String.valueOf(hiddenNumber);
        }
        Engine.run("What number is missing in the progression?", ROUNDS_DATA);
    }

    private static String[] generateProgression(int length) {
        String[] progression = new String[length];
        int start = Utils.getRandom();
        final int minStep = 2;
        final int maxStep = 10;
        int diff = Utils.getRandom(minStep, maxStep);

        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * diff);
        }

        return progression;
    }
}

