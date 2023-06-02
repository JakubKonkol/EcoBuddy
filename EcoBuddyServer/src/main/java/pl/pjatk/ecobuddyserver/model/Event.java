package pl.pjatk.ecobuddyserver.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;
    @Column
    private String description;
    @Column
    private String location;
    @Column
    private LocalDateTime date;
    @Column
    private String img;

}
