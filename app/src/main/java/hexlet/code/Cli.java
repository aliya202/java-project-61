package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void sayHello() {
        Scanner scanner = new Scanner(System.in);
        Engine.welcome();
        Engine.hello(scanner.next());
        scanner.close();
    }
}
