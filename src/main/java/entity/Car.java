package entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_car")
    @SequenceGenerator(name="generator_car", sequenceName = "sequence_car", allocationSize = 1)
    @Column(name = "id_car", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "colorCar", nullable = false)
    private String couleur;
    @Column(name = "poids", nullable = false)
    private BigDecimal poids;
    @Column(name = "gasType", nullable = false, length = 50)
    private String typeCarburant;
    @Column(name = "numberCarAvailable", nullable = false)
    private int nombreDisponible;

    @OneToMany(mappedBy = "car")
    private Set<Location> Locations;

    @ManyToOne
    @JoinColumn(name = "modele_id")
    private Modele modele;
}
