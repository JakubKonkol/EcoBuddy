package pl.pjatk.ecobuddyserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import pl.pjatk.ecobuddyserver.model.enums.Priority;
import pl.pjatk.ecobuddyserver.model.enums.Status;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String desc;
    private Priority priority;
    private Status status;
}