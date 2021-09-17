package guide.springboot.sample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskSpringDataService taskService;

    public TaskController(TaskSpringDataService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskJson> getTasks() {
        List<Task> tasks = taskService.selectAll();
        return tasks.stream()
                .map(TaskController::toTaskJson)
                .collect(Collectors.toUnmodifiableList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskNoIdJson> getTask(@PathVariable("id") final String id) {
        TaskIdentifier identifier = new TaskIdentifier(id);
        Optional<Task> task = taskService.select(identifier);
        return ResponseEntity.of(task.map(TaskController::toTaskNoIdJson));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskIdentifierJson createTask(@RequestBody final TaskCreateAttributeJson attributeJson) {
        TaskCreateAttribute request = new TaskCreateAttribute(attributeJson.getDetails());
        TaskIdentifier identifier = taskService.insert(request);
        return new TaskIdentifierJson(identifier.getValue());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskNoIdJson> updateTasks(@PathVariable("id") final String id, @RequestBody final TaskUpdateAttributeJson attributeJson) {
        TaskUpdateAttribute request = new TaskUpdateAttribute(id, attributeJson.getStatus(), attributeJson.getDetails());
        Optional<Task> task = taskService.update(request);
        return ResponseEntity.of(task.map(TaskController::toTaskNoIdJson));
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") final String id) {
        TaskIdentifier identifier = new TaskIdentifier(id);
        taskService.delete(identifier);
    }

    static TaskJson toTaskJson(final Task task) {
        final var id = task.getIdentifier().getValue();
        return new TaskJson(id, task.getDetails(), task.getStatus());
    }

    static TaskNoIdJson toTaskNoIdJson(final Task task) {
        return new TaskNoIdJson(task.getDetails(), task.getStatus());
    }
}
