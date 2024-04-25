package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Progression {

    public static String[][] getProgression() {
        final String[][] values = new String[Engine.ROUNDS][Engine.RESULTS];

        for (var i = 0; i < Engine.ROUNDS; i++) {
            String[] progressionArray = generateProgression();
            int hiddenElementIndex = Utils.getRandom(0, progressionArray.length);

            String hiddenElement = progressionArray[hiddenElementIndex];
            progressionArray[hiddenElementIndex] = "..";

            var question = String.join(" ", progressionArray);

            values[i][0] = question;
            values[i][1] = hiddenElement;

        }
        return values;
    }

    public static String[] generateProgression() {
        final int minSize = 5;
        final int maxSize = 10;
        final int progressionLength = Utils.getRandom(minSize, maxSize);
        String[] progressionArray = new String[progressionLength];

        int current = Utils.getRandom();
        int difference = Utils.getRandom();

        for (var i = 0; i < progressionLength; i++) {

            progressionArray[i] = String.valueOf(current);
            current += difference;
        }
        return progressionArray;
    }

    public static void run() {
        Engine.run("What number is missing in the progression?", getProgression());
    }
}
