package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Calc extends Game {

    private static final int MIN_BOUNDARY = 1;
    private static final int MAX_BOUNDARY = 20;
    private static final String[] operations = {"+", "-", "*"};

    @Override
    public String[][] generate(int rounds) {
        final String[][] values = new String[rounds][3];

        for (int i = 0; i < rounds; i++) {
            int num1 = Utils.getRandom(MIN_BOUNDARY, MAX_BOUNDARY);
            int num2 = Utils.getRandom(MIN_BOUNDARY, MAX_BOUNDARY);
            String operation = operations[Utils.getRandom(0, operations.length)];

            values[i][0] = String.valueOf(num1);
            values[i][1] = operation;
            values[i][2] = String.valueOf(num2);
        }

        return values;
    }

    @Override
    public EngineData[] transform(String[][] rowValues) {
        int rounds = rowValues.length;
        final EngineData[] engineData = new EngineData[rounds];

        for (int i = 0; i < rounds; i++) {
            int num1 = Integer.parseInt(rowValues[i][0]);
            String operation = rowValues[i][1];
            int num2 = Integer.parseInt(rowValues[i][2]);

            int answer;
            switch (operation) {
                case "+":
                    answer = num1 + num2;
                    break;
                case "-":
                    answer = num1 - num2;
                    break;
                default:
                    answer = num1 * num2;
            }

            String[] values = new String[3];
            values[0] = String.valueOf(num1);
            values[1] = operation;
            values[2] = String.valueOf(num2);

            engineData[i] = new EngineData(values, String.valueOf(answer));
        }

        return engineData;
    }

    @Override
    public void run(EngineData[] engineData) {
        Engine.run("What is the result of the expression?.", engineData);
    }
}
