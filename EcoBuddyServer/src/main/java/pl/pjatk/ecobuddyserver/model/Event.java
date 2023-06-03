package pl.pjatk.ecobuddyserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String location;
    private LocalDateTime date;
    private String img;
    private boolean completed;
    @ManyToMany(mappedBy = "events")
    @JsonIgnoreProperties("events")
    private List<User> participants = new ArrayList<>();




}
