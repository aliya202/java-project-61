package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void run(String description, String[][] roundsData) {
        Scanner scanner = new Scanner(System.in);
        String name = Cli.greet(scanner);
        System.out.println(description);
        int correctAnswersCount = 0;

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
            if (correctAnswersCount == 3) {
                System.out.println("Congratulations, " + name + "!");
            }
        }
        scanner.close();
    }
}

