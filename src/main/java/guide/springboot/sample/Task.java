package guide.springboot.sample;

public class Task {
    private final TaskIdentifier identifier;
    private final String details;
    private final String status;

    public Task(TaskIdentifier identifier, String details, String status) {
        this.identifier = identifier;
        this.details = details;
        this.status = status;
    }

    public TaskIdentifier getIdentifier() {
        return identifier;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }
}
