package pl.pjatk.ecobuddyserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.ecobuddyserver.model.Task;
import pl.pjatk.ecobuddyserver.repository.EventRepository;
import pl.pjatk.ecobuddyserver.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final EventRepository eventRepository;

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task getTaskById(long taskId) {
        var optionalTask =  taskRepository.findById(taskId);

        if(optionalTask.isEmpty()) {
            throw new NoSuchElementException("There's no task with given id");
        }

        return optionalTask.get();
    }

    public Task updateTaskById(long taskId, Task updatedTask) {
        var optionalTask =  taskRepository.findById(taskId);

        if(optionalTask.isEmpty()) {
            throw new NoSuchElementException("There's no task with given id");
        }

        Task taskToUpdate = optionalTask.get();

        if(updatedTask.getDescription() != null) {
            taskToUpdate.setDescription(updatedTask.getDescription());
        }

        if(updatedTask.getPriority() != null) {
            taskToUpdate.setPriority(updatedTask.getPriority());
        }
        if(updatedTask.getStatus() != null) {

            taskToUpdate.setStatus(updatedTask.getStatus());
        }
        if(updatedTask.getCompltionDate() != null){
            taskToUpdate.setCompltionDate(updatedTask.getCompltionDate());
        }
        return taskToUpdate;
    }

    public void deleteTaskById(long taskId) {
        var optionalTask =  taskRepository.findById(taskId);

        if(optionalTask.isEmpty()) {
            throw new NoSuchElementException("There's no task with given id");
        }

        taskRepository.delete(optionalTask.get());
    }

    public List<Task> getDailyTasks() {
        List<Task> randomTasks = taskRepository.findRandomTasks();
        Random random = new Random();

        for(Task t: randomTasks) {
            int randomNumber = random.nextInt(20);
            String descriptionWithValue = String.format(t.getDescription(), randomNumber);
            t.setDescription(descriptionWithValue);
        }

        return randomTasks;
    }
    public List<Task> getByCompltionDate(LocalDateTime compltionDate ){
        return taskRepository.getByCompltionDate(compltionDate);
    }
}
