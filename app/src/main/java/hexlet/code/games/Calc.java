package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_DATA;


public class Calc {
    private static final int MIN_BOUNDARY = 1;
    private static final int MAX_BOUNDARY = 20;

    public static void runGame() {
        for (int i = 0; i < ROUNDS_DATA.length; i++) {
            int num1 = Utils.getRandom(MIN_BOUNDARY, MAX_BOUNDARY);
            int num2 = Utils.getRandom(MIN_BOUNDARY, MAX_BOUNDARY);
            String[] operations = {"+", "-", "*"};
            String operation = operations[Utils.getRandom(0, operations.length)];
            int value;
            switch (operation) {
                case "+":
                    value = num1 + num2;
                    break;
                case "-":
                    value = num1 - num2;
                    break;
                default:
                    value = num1 * num2;
            }

            ROUNDS_DATA[i][0] = String.format("%d %s %d", num1, operation, num2);
            ROUNDS_DATA[i][1] = String.valueOf(value);
        }
        Engine.run("What is the result of the expression?.", ROUNDS_DATA);
    }
}
