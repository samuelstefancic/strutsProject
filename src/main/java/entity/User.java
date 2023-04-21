package entity;

import jakarta.validation.constraints.Pattern;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_user")
    @SequenceGenerator(name="generator_user", sequenceName = "sequence_user", allocationSize = 1)
    @Column(name = "id_user", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "username",length = 50, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    @Pattern(regexp = "^(?=.*\\S)(?=.* \\S){5,}(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).*$")
    private String password;

    @Column(name = "userlstname", length = 255, nullable = false)
    private String nom;

    @OneToMany(mappedBy="user")
    private Set<Location> Locations;
}