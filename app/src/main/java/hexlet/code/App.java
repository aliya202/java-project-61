package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static final int ROUNDS = 3;
    public static final int RESULTS = 2;
    public static final String[][] ROUNDS_DATA = new String[ROUNDS][RESULTS];
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String selectedGame = scanner.next();
        System.out.println();

        switch (selectedGame) {
            case "1" -> Cli.greet(scanner);
            case "2" -> Even.runGame(ROUNDS_DATA);
            case "3" -> Calc.runGame(ROUNDS_DATA);
            case "4" -> GCD.runGame(ROUNDS_DATA);
            case "5" -> Progression.runGame(ROUNDS_DATA);
            case "6" -> Prime.runGame(ROUNDS_DATA);
            default -> System.out.println("Exit");
        }
        scanner.close();
    }
}
