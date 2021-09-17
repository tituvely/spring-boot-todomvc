package guide.springboot.sample;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskSpringDataService implements TaskService {

    private final TaskRepository taskRepository;
    private final IdGenerator idGenerator;

    public TaskSpringDataService(TaskRepository taskRepository, IdGenerator idGenerator) {
        this.taskRepository = taskRepository;
        this.idGenerator = idGenerator;
    }

    static Task toService(final TaskEntity entity) {
        final var identifier = new TaskIdentifier(entity.getId());

        return new Task(identifier, entity.getDetails(), entity.getStatus());
    }

    public TaskIdentifier insert(TaskCreateAttribute attributes) {
        String id = idGenerator.generateId();
        TaskEntity taskEntity = new TaskEntity(id, attributes.getDetails(), "active");
        TaskEntity save = taskRepository.save(taskEntity);
        return new TaskIdentifier(save.getId());
    }

    public Optional<Task> select(final TaskIdentifier identifier) {
        String id = identifier.getValue();
        return taskRepository.findById(id)
                .map(TaskSpringDataService::toService);
    }

    public List<Task> selectAll() {
        List<TaskEntity> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(TaskSpringDataService::toService)
                .collect(Collectors.toUnmodifiableList());
    }

    public Optional<Task> update(final TaskUpdateAttribute attributes) {
        TaskEntity findTask = taskRepository.getById(attributes.getId());
        TaskEntity taskEntity;
        if(attributes.getDetails() == null) {
            taskEntity = new TaskEntity(findTask.getId(), findTask.getDetails(), attributes.getStatus());
        } else if(attributes.getStatus() == null) {
            taskEntity = new TaskEntity(findTask.getId(), attributes.getDetails(), findTask.getStatus());
        } else {
            taskEntity = new TaskEntity(findTask.getId(), attributes.getDetails(), attributes.getStatus());
        }
        TaskEntity save = taskRepository.save(taskEntity);
        return taskRepository.findById(save.getId())
                .map(TaskSpringDataService::toService);
    }

    public void delete(final TaskIdentifier identifier) {
        String id = identifier.getValue();
        try {
            taskRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignored) {
            System.out.println("No book entity. (id={" + id + "})");
        }
    }

}
