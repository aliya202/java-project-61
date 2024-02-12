package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {

    public static void runGame() {
        String[][] roundsData = new String[3][2];
        for (int i = 0; i < 3; i++) {
            int num1 = Utils.getRandom();
            int num2 = Utils.getRandom();
            int gcd = findGCD(num1, num2);

            roundsData[i][0] = String.valueOf(String.format("%d %d", num1, num2));

            roundsData[i][1] = String.valueOf(gcd);
        }
        Engine.run("Find the greatest common divisor of given numbers.", roundsData);
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
