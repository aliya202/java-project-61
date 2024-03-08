package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.Game;
import hexlet.code.games.EngineData;
import java.util.Scanner;

import static hexlet.code.Engine.ROUNDS_DATA;

public class App {

    public static void main(String[] args) {
        Game newCalc = new Calc();
        Game even = new Even();
        Game progression = new Progression();
        Game gcd = new GCD();
        Game prime = new Prime();

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
            case "1" -> Cli.sayHello();
            case "2" -> {
                String[][] generate = even.generate(ROUNDS_DATA.length);
                EngineData[] transform = even.transform(generate);
                even.run(transform);
            }
            case "3" -> {
                String[][] generate = newCalc.generate(ROUNDS_DATA.length);
                EngineData[] transform = newCalc.transform(generate);
                newCalc.run(transform);
            }
            case "4" -> {
                String[][] generate = gcd.generate(ROUNDS_DATA.length);
                EngineData[] transform = gcd.transform(generate);
                gcd.run(transform);
            }
            case "5" -> {
                String[][] generate = progression.generate(ROUNDS_DATA.length);
                EngineData[] transform = progression.transform(generate);
                progression.run(transform);
            }
            case "6" -> {
                String[][] generate = prime.generate(ROUNDS_DATA.length);
                EngineData[] transform = prime.transform(generate);
                prime.run(transform);
            }
            default -> System.out.println("Exit");
        }
        scanner.close();
    }
}
