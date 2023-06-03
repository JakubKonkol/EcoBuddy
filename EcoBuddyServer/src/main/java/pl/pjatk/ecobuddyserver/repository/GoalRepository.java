package pl.pjatk.ecobuddyserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.ecobuddyserver.model.Goal;
import pl.pjatk.ecobuddyserver.model.enums.EventType;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    List<Goal> findGoalsByCity(String city);
  List<Goal> findGoalsByType(EventType type);
}
