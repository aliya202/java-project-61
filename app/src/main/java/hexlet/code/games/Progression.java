package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {

    private static String[][] generate(Integer firstElement, Integer step, Integer progressionLength) {
        final int minLength = 6;
        final int maxLength = 10;
        final int minStep = 2;
        final int maxStep = 10;
        int length = progressionLength == null ? maxLength : progressionLength + 1;
        final String[][] values = new String[Engine.ROUNDS][length];

        for (int j = 0; j < values.length; j++) {
            int newLength = progressionLength == null ? Utils.getRandom(minLength, maxLength) : progressionLength + 1;
            int diff = step == null ? Utils.getRandom(minStep, maxStep) : step;
            int start = firstElement == null ? Utils.getRandom() : firstElement;
            values[j][0] = String.valueOf(newLength);
            int iterate = progressionLength == null ? newLength : newLength - 1;
            for (int i = 0; i < iterate; i++) {
                values[j][i + 1] = String.valueOf(start + i * diff);
            }
        }
        return values;
    }

    private static String[][] transform(Integer firstElement, Integer step, Integer lengthOfProgression) {
        String[][] generate = generate(firstElement, step, lengthOfProgression);
        int rounds = generate.length;
        String[][] transformed = Engine.ROUNDS_DATA;

        for (int i = 0; i < rounds; i++) {
            int length = Integer.parseInt(generate[i][0]);
            int hiddenIndex = Utils.getRandom(1, length - 1);
            String answer = generate[i][hiddenIndex];
            String[] sequence = new String[length - 1];

            for (int j = 0; j < length - 1; j++) {
                if (j + 1 == hiddenIndex) {
                    sequence[j] = "..";
                } else {
                    sequence[j] = generate[i][j + 1];
                }
            }

            StringBuilder sb = new StringBuilder();
            for (String str : sequence) {
                sb.append(str).append(" ");
            }
            transformed[i][0] = sb.toString();
            transformed[i][1] = answer;
        }

        return transformed;
    }

    public static void run() {
        Engine.run("What number is missing in the progression?", transform(null, null, null));
    }
}
