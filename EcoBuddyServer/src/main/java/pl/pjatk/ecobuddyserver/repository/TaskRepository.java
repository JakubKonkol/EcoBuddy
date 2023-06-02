package pl.pjatk.ecobuddyserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.ecobuddyserver.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
