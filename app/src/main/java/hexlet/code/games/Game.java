package hexlet.code.games;

import hexlet.code.Engine;

public abstract class Game {
    public abstract String[][] generate(int rounds);

    public abstract EngineData[] transform(String[][] values);

    public abstract void run(EngineData[] engineData);
}
