package hexlet.code.games;

public class EngineData {
    private final String[] values;
    private final String answer;

    public EngineData(String[] values, String answer) {
        this.values = values;
        this.answer = answer;
    }

    public String[] getValues() {
        return values;
    }

    public String getAnswer() {
        return answer;
    }
}
