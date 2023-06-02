package pl.pjatk.ecobuddyserver.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private Long points;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Task> taskHistory;
}
