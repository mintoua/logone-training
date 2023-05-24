package logonedigital.springcourse.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "cours")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Cours extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;


    @ManyToMany(mappedBy = "coursInscrits")
    private List<Etudiant> etudiantsInscrits = new ArrayList<>();

    @ManyToMany(mappedBy = "coursEnseignes")
    private List<Enseignant> enseignants = new ArrayList<>();

}
