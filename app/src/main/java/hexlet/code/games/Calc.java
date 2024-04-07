package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {

    private static final int MIN_BOUNDARY = 1;
    private static final int MAX_BOUNDARY = 20;
    private static final String[] OPERATIONS = {"+", "-", "*"};
    private static final int ARR_LENGTH = 3;

    private static String[][] generate() {
        final String[][] values = new String[Engine.ROUNDS][ARR_LENGTH];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int num1 = Utils.getRandom(MIN_BOUNDARY, MAX_BOUNDARY);
            int num2 = Utils.getRandom(MIN_BOUNDARY, MAX_BOUNDARY);
            String operation = OPERATIONS[Utils.getRandom(0, OPERATIONS.length)];

            values[i][0] = String.valueOf(num1);
            values[i][1] = operation;
            values[i][2] = String.valueOf(num2);
        }

        return values;
    }

    private static String[][] transform() {
        String[][] rowValues = generate();
        String[][] transformed = Engine.ROUNDS_DATA;
        int rounds = rowValues.length;

        for (int i = 0; i < rounds; i++) {
            int num1 = Integer.parseInt(rowValues[i][0]);
            String operation = rowValues[i][1];
            int num2 = Integer.parseInt(rowValues[i][2]);

            int answer = switch (operation) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                default -> num1 * num2;
            };

            transformed[i][0] = String.format("%d %s %d", num1, operation, num2);
            transformed[i][1] = String.valueOf(answer);
        }

        return transformed;
    }

    public static void run() {
        Engine.run("What is the result of the expression?.", transform());
    }
}
