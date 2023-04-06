package entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "modele")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_modele")
    @SequenceGenerator(name = "generator_modele", sequenceName = "sequence_modele")
    @Column(name = "id_modele", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "nom", nullable = false, unique = true)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "marque_id")
    private Marque marque;

    @OneToMany(mappedBy = "modele")
    private Set<Car> cars;
}
