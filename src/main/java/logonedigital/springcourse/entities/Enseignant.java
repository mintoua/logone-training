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

//@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "formateurs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Enseignant extends AbstractEntity implements Serializable {

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
            name = "enseignant_cours",
            joinColumns = @JoinColumn(name = "enseignant_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id"))
    private List<Cours> coursEnseignes = new ArrayList<>();



}
