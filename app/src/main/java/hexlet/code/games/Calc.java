package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Calc {
    private static final int minBoundary = 1;
    private static final int maxBoundary = 20;

    public static void runGame() {
        String[][] roundsData = new String[3][2];
        for (int i = 0; i < 3; i++) {
            String[] objects = generateQuestionAndAnswer();
            roundsData[i][0] = objects[0];

            roundsData[i][1] = objects[1];
        }
        Engine.run("What is the result of the expression?.", roundsData);
    }

    private static String[] generateQuestionAndAnswer() {
        int num1 = Utils.getRandom(minBoundary, maxBoundary);
        int num2 = Utils.getRandom(minBoundary, maxBoundary);
        String[] operations = {"+", "-", "*"};
        String operation = operations[Utils.getRandom(0, operations.length)];
        String[] objects = new String[2];
        switch (operation) {
            case "+":
                objects[0] = String.format("%d + %d", num1, num2);
                objects[1] = String.valueOf(num1 + num2);
                break;
            case "-":
                objects[0] = String.format("%d - %d", num1, num2);
                objects[1] = String.valueOf(num1 - num2);
                break;
            default:
                objects[0] = String.format("%d * %d", num1, num2);
                objects[1] = String.valueOf(num1 * num2);
                break;
        }
        return objects;
    }
}

