package guide.springboot.sample;

public class TaskCreateAttribute {
    private final String details;

    public TaskCreateAttribute(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
