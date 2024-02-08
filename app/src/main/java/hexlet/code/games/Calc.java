package hexlet.code.games;

import java.util.Random;

import java.util.Scanner;

public class Calc {
    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Calculator game!");
        System.out.print("What's your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "! Let's start.");

        int correctAnswersCount = 0; //счетчик успешных раундов
        for (int i = 0; i < 3; i++) {
            String[] objects = generateQuestionAndAnswer();
            String question  = objects[0];
            int answer = Integer.parseInt(objects[1]);

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine();

            if (userAnswer == answer) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + answer + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (correctAnswersCount == 3) {
            System.out.println("Congratulations, " + name + "!");
        }

        scanner.close();
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
            case "*":
                objects[0] = String.format("%d * %d", num1, num2);
                objects[1] = String.valueOf(num1 * num2);
                break;
        }
        return objects;
    }
}

