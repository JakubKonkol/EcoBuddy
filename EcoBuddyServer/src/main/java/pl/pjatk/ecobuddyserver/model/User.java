package pl.pjatk.ecobuddyserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import pl.pjatk.ecobuddyserver.model.enums.UserStatus;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String nickname;
    private Long points;
    private UserStatus userStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_event")
    @JsonIgnore
    private Event event;
}

