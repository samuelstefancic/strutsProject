package entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "marque")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "geneartor_marque")
    @SequenceGenerator(name = "generator_marque", sequenceName = "sequence_marque")
    @Column(name = "id_marque", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name="nom", nullable = false, unique = true)
    private String nom;

    @OneToMany(mappedBy = "marque")
    private Set<Modele> modeles;
}
