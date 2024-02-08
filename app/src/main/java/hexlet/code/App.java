package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String selectedGame = scanner.next();
        System.out.println();

        switch (selectedGame) {
            case "1":
                Cli.greet();
            case "2":
                Even.runGame();
            case "0":
                System.out.println("Exit");
                break;
        }

        scanner.close();
    }
}
