package hexlet.code.games;

public final class EngineData {
    private final String[] values;
    private final String answer;

    public EngineData(String[] values1, String answer1) {
        this.values = values1;
        this.answer = answer1;
    }

    public String[] getValues() {
        return values;
    }

    public String getAnswer() {
        return answer;
    }
}
