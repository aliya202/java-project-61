package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Progression {
    public static final int MIN_SIZE = 5;
    public static final int MAX_SIZE = 10;
    public static final int MIN_STEP = 2;
    public static final int MAX_STEP = 5;

    public static String[][] getProgression() {
        final String[][] values = new String[Engine.ROUNDS][Engine.RESULTS];

        for (var i = 0; i < Engine.ROUNDS; i++) {
            int progressionLength = Utils.getRandom(MIN_SIZE, MAX_SIZE);
            int startElement = Utils.getRandom();
            int step = Utils.getRandom(MIN_STEP, MAX_STEP);
            String[] progressionArray = generateProgression(progressionLength, startElement, step);
            int hiddenElementIndex = Utils.getRandom(0, progressionArray.length);

            String hiddenElement = progressionArray[hiddenElementIndex];
            progressionArray[hiddenElementIndex] = "..";

            var question = String.join(" ", progressionArray);

            values[i][0] = question;
            values[i][1] = hiddenElement;

        }
        return values;
    }

    public static String[] generateProgression(int progressionLength, int startElement, int step) {
        String[] progressionArray = new String[progressionLength];

        for (var i = 0; i < progressionLength; i++) {

            progressionArray[i] = Integer.toString(startElement);
            startElement += step;
        }
        return progressionArray;
    }

    public static void run() {
        Engine.run("What number is missing in the progression?", getProgression());
    }
}
