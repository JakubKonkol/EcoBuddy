package pl.pjatk.ecobuddyserver.model;

import jakarta.persistence.*;
import lombok.Data;
import pl.pjatk.ecobuddyserver.model.enums.EventType;

@Entity
@Data
@Table(name = "goal")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private EventType type;
    private double moneyCollected;
    private double moneyNeeded;
    private String foundationName;
    private String description;

}
