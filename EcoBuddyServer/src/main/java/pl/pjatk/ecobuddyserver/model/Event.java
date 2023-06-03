package pl.pjatk.ecobuddyserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.ArrayList;


@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;
    private String description;
    private String location;
    private LocalDateTime date;
    private String img;
    private boolean completed;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
    @JsonIgnore
    private List<User> participants = new ArrayList<>();




}
