package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Even extends Game {

    @Override
    public String[][] generate(int rounds) {
        final String[][] values = new String[rounds][1];

        for (int i = 0; i < rounds; i++) {
            int randomNumber = Utils.getRandom();
            values[i][0] = String.valueOf(randomNumber);
        }
        return values;
    }

    @Override
    public EngineData[] transform(String[][] rowValues) {
        int rounds = rowValues.length;
        final EngineData[] engineData = new EngineData[rounds];

        for (int i = 0; i < rounds; i++) {
            String answer = isEven(Integer.parseInt(rowValues[i][0])) ? "yes" : "no";
            engineData[i] = new EngineData(rowValues[i], answer);
        }

        return engineData;
    }

    @Override
    public void run(EngineData[] engineData) {
        Engine.run("Answer 'yes' if the number is even, otherwise answer 'no'.", engineData);
    }

    public static boolean isEven(int randomNumber) {
        return randomNumber % 2 == 0;
    }
}
