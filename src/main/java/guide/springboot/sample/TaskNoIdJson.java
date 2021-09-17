package guide.springboot.sample;

public class TaskNoIdJson {
    private final String details;
    private final String status;

    TaskNoIdJson(final String details, final String status) {
        this.details = details;
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }
}
