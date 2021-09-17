package guide.springboot.sample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public
class TaskEntity {

    @Id
    private String id;
    private String details;
    private String status;

    public TaskEntity() {}

    public TaskEntity(String id, String details, String status) {
        this.id = id;
        this.details = details;
        this.status = status;
    }

    public TaskEntity(String id, String details) {
        this.id = id;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }
}
