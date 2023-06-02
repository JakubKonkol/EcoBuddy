package pl.pjatk.ecobuddyserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pjatk.ecobuddyserver.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT * FROM task ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Task> findRandomTasks();
}
