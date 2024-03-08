package hexlet.code;

import hexlet.code.games.EngineData;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;
    public static final int RESULTS = 2;
    public static final String[][] ROUNDS_DATA = new String[ROUNDS][RESULTS];

    public static void run(String description, EngineData[] roundsData) {
        Scanner scanner = new Scanner(System.in);
        welcome();
        String name = hello(scanner.next());
        System.out.println(description);
        int correctAnswersCount = 0;
        final int successAttempts = 3;

        for (EngineData round : roundsData) {
            System.out.print("Question:");
            for (String value: round.getValues()) {
                System.out.print(" " + value);
            }
            System.out.println();

            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equals(round.getAnswer())) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + (round.getAnswer() + "'."));
                System.out.println("Let's try again, " + name + "!");
                break;
            }

            if (correctAnswersCount == successAttempts) {
                System.out.println("Congratulations, " + name + "!");
            }
        }
        scanner.close();
    }

    public static void welcome() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
    }

    public static String hello(String username) {
        System.out.println("Hello, " + username + "!");
        return username;
    }
}


