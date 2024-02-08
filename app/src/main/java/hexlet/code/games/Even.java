package hexlet.code.games;

import java.util.Scanner;

import java.util.Random;

public class Even {
    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswersCount = 0; //счетчик успешных раундов
        for (int i = 0; i < 3; i++) {
            int randomNumber = (int) (Math.random() * 100);  //генерирую рандомное число
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            boolean isEven = randomNumber % 2 == 0; //проверяю четность
            boolean isCorrect = (isEven && userAnswer.equals("yes")) || (!isEven && userAnswer.equals("no"));
            //проверяю ответ игрока

            if (isCorrect) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + (isEven ? "no" : "yes") + "'.");
                //при ошибке тернарным вычисляю верный ответ
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (correctAnswersCount == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
