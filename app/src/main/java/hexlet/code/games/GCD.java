package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD extends Game {

    public String[][] generate(int rounds) {
        final String[][] values = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            int num1 = Utils.getRandom();
            int num2 = Utils.getRandom();

            values[i][0] = String.valueOf(num1);
            values[i][1] = String.valueOf(num2);
        }

        return values;
    }

    @Override
    public EngineData[] transform(String[][] rowValues) {
        int rounds = rowValues.length;
        final EngineData[] engineData = new EngineData[rounds];

        for (int i = 0; i < rounds; i++) {
            String answer = String.valueOf(findGCD(Integer.parseInt(rowValues[i][0]),
                    Integer.parseInt(rowValues[i][1])));
            engineData[i] = new EngineData(rowValues[i], answer);
        }
        return engineData;
    }

    @Override
    public void run(EngineData[] engineData) {
        Engine.run("Find the greatest common divisor of given numbers.", engineData);
    }

    public int findGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}
