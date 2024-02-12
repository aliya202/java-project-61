package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Calc {
    private static final int MIN_BOUNDARY = 1;
    private static final int MAX_BOUNDARY = 20;

    public static void runGame(String[][] roundsData) {
        for (int i = 0; i < roundsData.length; i++) {
            String[] objects = generateQuestionAndAnswer();
            roundsData[i][0] = objects[0];

            roundsData[i][1] = objects[1];
        }
        Engine.run("What is the result of the expression?.", roundsData);
    }

    private static String[] generateQuestionAndAnswer() {
        int num1 = Utils.getRandom(MIN_BOUNDARY, MAX_BOUNDARY);
        int num2 = Utils.getRandom(MIN_BOUNDARY, MAX_BOUNDARY);
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

