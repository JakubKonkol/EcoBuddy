package pl.pjatk.ecobuddyserver.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private Double points;
//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Task> taskHistory; //TODO: Dodać po zrobieniu Task
}
