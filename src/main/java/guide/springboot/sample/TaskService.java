package guide.springboot.sample;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    TaskIdentifier insert(final TaskCreateAttribute attributes);

    void delete(final TaskIdentifier identifier);

    Optional<Task> select(final TaskIdentifier identifier);

    List<Task> selectAll();

    Optional<Task> update(final TaskUpdateAttribute attributes);
}
