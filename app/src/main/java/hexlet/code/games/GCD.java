package hexlet.code.games;

import java.util.Random;

import java.util.Scanner;
public class GCD {
    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");
        System.out.println("Find the greatest common divisor of given numbers.");

        int correctAnswersCount = 0;

        for (int i = 0; i < 3; i++) {
            int num1 = (int) (Math.random() * 100);
            int num2 = (int) (Math.random() * 100);
            int gcd = findGCD(num1, num2);

            System.out.println("Question: " + num1 + " " + num2);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == gcd) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + gcd + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (correctAnswersCount == 3) {
            System.out.println("Congratulations, " + name + "!");
        }

        scanner.close();
    }

    public static int findGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}
