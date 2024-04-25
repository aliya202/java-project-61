package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {

    private static final int MIN_BOUNDARY = 1;
    private static final int MAX_BOUNDARY = 20;
    private static final String[] OPERATIONS = {"+", "-", "*"};


    public static String[][] getCalc() {
        final String[][] values = new String[Engine.ROUNDS][Engine.RESULTS];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int num1 = Utils.getRandom(MIN_BOUNDARY, MAX_BOUNDARY);
            int num2 = Utils.getRandom(MIN_BOUNDARY, MAX_BOUNDARY);
            String operation = OPERATIONS[Utils.getRandom(0, OPERATIONS.length)];
            int answer = getResult(operation, num1, num2);

            values[i][0] = String.format("%d %s %d", num1, operation, num2);
            values[i][1] = String.valueOf(answer);
        }

        return values;
    }

    private static int getResult(String operation, int num1, int num2) {
        return switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new RuntimeException("Operator not found");
        };
    }

    public static void run() {
        Engine.run("What is the result of the expression?.", getCalc());
    }
}

