package entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Location {

    @Id
    @Column(name = "id_location", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_location")
    @SequenceGenerator(name = "generator_location", sequenceName = "sequence_location", allocationSize = 1)
    private UUID id;

    @Column(name = "dateDebut", nullable = false)
    private Date dateDebut;

    @Column(name = "dateFin", nullable = false)
    private Date dateFin;

    @Column(name = "cautionLocation", nullable = false)
    private BigDecimal caution;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Car car;

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", caution=" + caution +
                ", user=" + user +
                ", car=" + car +
                '}';
    }
}
