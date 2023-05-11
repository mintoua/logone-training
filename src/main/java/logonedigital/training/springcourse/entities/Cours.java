package logonedigital.training.springcourse.entities;

import jakarta.persistence.*;
import lombok.*;

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
public class Cours extends AbstractEntity {

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
