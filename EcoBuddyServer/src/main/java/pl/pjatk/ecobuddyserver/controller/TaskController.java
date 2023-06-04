package pl.pjatk.ecobuddyserver.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.ecobuddyserver.model.Task;
import pl.pjatk.ecobuddyserver.service.TaskService;
import java.util.List;

@RestController
@RequestMapping("api/v1/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @PostMapping("/save")
    public ResponseEntity<Task> saveTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.save(task));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/findById/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable long taskId) {
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }
    @PutMapping("/update/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable long taskId, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTaskById(taskId, task));
    }
    @DeleteMapping("/deleteById/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable long taskId){
        taskService.deleteTaskById(taskId);
        return ResponseEntity.ok("Task of id: " + taskId + " has been deleted");
    }
    @GetMapping("/dailyTasks")
    public ResponseEntity<List<Task>> getDailyTasks(){
        return ResponseEntity.ok(taskService.getDailyTasks());
    }
}
