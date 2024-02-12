package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min)) + min;
    }

    public static int getRandom() {
        final int minBoundary = 1;
        final int maxBoundary = 100;
        return getRandom(minBoundary, maxBoundary);
    }
}
