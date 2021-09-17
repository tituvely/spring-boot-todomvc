package guide.springboot.sample;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskCreateAttributeJson {
    private final String details;

    @JsonCreator
    public TaskCreateAttributeJson(@JsonProperty("details") final String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
