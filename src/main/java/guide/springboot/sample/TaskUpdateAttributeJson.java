package guide.springboot.sample;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskUpdateAttributeJson {
    private final String status;
    private final String details;

    @JsonCreator
    public TaskUpdateAttributeJson(@JsonProperty("status") final String status, @JsonProperty("details") final String details) {
        this.status = status;
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }
}
