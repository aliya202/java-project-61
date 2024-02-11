package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
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
        Random random = new Random();
        int num1 = (int) (Math.random() * 20);
        int num2 = (int) (Math.random() * 20);
        String[] operations = {"+", "-", "*"};
        String operation = operations[random.nextInt(operations.length)];
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

