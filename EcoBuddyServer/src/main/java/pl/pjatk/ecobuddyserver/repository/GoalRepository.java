package pl.pjatk.ecobuddyserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.ecobuddyserver.model.Goal;

import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    Optional<Goal> findGoalByCity(String city);
}
