package logonedigital.springcourse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "etudiants")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Etudiant extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(
            name = "etudiant_cours",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id"))
    private List<Cours> coursInscrits = new ArrayList<>();
}
