package pl.pjatk.ecobuddyserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.ecobuddyserver.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
