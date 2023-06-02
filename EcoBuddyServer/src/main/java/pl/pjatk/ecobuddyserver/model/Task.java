package pl.pjatk.ecobuddyserver.model;

import jakarta.persistence.*;
import lombok.Data;
import pl.pjatk.ecobuddyserver.model.enums.Priority;
import pl.pjatk.ecobuddyserver.model.enums.Status;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDateTime compltionDate;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private User user;
}