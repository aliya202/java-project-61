package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;
    public static final int RESULTS = 2;
    public static final String[][] ROUNDS_DATA = new String[ROUNDS][RESULTS];

    public static void run(String description, String[][] roundsData) {
        Scanner scanner = new Scanner(System.in);
        String name = Cli.sayHello(scanner);
        System.out.println(description);
        int correctAnswersCount = 0;
        final int successAttempts = 3;

        for (String[] roundData : roundsData) {
            System.out.println("Question: " + roundData[0]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equals(roundData[1])) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + (roundData[1] + "'."));
                System.out.println("Let's try again, " + name + "!");
                break;
            }

            if (correctAnswersCount == successAttempts) {
                System.out.println("Congratulations, " + name + "!");
            }
        }
        scanner.close();
    }
}

