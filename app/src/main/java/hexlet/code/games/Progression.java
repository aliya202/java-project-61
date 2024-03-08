package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression extends Game {

    @Override
    public String[][] generate(int rounds) {
        final int minLength = 5;
        final int maxLength = 10;
        final int minStep = 2;
        final int maxStep = 10;
        final String[][] values = new String[rounds][maxLength];

        for (int j = 0; j < rounds; j++) {
            int length = Utils.getRandom(minLength, maxLength);
            int diff = Utils.getRandom(minStep, maxStep);
            int start = Utils.getRandom();

            values[j][0] = String.valueOf(length);

            for (int i = 0; i < length - 1; i++) {
                values[j][i + 1] = String.valueOf(start + i * diff);
            }
        }
        return values;
    }

    @Override
    public EngineData[] transform(String[][] rowValues) {
        int rounds = rowValues.length;
        final EngineData[] engineData = new EngineData[rounds];

        for (int i = 0; i < rounds; i++) {
            int length = Integer.parseInt(rowValues[i][0]);
            int hiddenIndex = Utils.getRandom(1, length - 1);
            String answer = rowValues[i][hiddenIndex];
            String[] sequence = new String[length - 1];

            for (int j = 0; j < length - 1; j++) {
                if (j + 1 == hiddenIndex) {
                    sequence[j] = "..";
                } else {
                    sequence[j] = rowValues[i][j + 1];
                }
            }

            engineData[i] = new EngineData(sequence, answer);
        }

        return engineData;
    }

    @Override
    public void run(EngineData[] engineData) {
        Engine.run("What number is missing in the progression?", engineData);
    }
}