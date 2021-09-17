package guide.springboot.sample;

public class TaskIdentifier {
    private final String value;

    public TaskIdentifier(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
