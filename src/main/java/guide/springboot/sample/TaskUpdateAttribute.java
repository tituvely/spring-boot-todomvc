package guide.springboot.sample;

public class TaskUpdateAttribute {
    private final String id;
    private final String status;
    private final String details;

    public TaskUpdateAttribute(String id, String status, String details) {
        this.id = id;
        this.status = status;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }
}
