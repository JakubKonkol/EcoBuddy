package pl.pjatk.ecobuddyserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.ecobuddyserver.model.Event;

@Repository
public interface EventRepository  extends JpaRepository<Event, Long> {


}
