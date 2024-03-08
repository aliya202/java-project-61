package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Prime extends Game {

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
            String answer = isPrime(Integer.parseInt(rowValues[i][0])) ? "yes" : "no";
            engineData[i] = new EngineData(rowValues[i], answer);
        }
        return engineData;
    }

    @Override
    public void run(EngineData[] engineData) {
        Engine.run("Answer 'yes' if given number is prime. Otherwise answer 'no'.", engineData);
    }

    public boolean isPrime(int randomNumber) {
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
