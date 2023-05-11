package logonedigital.training.springcourse.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EnseignantDto {

    private String nom;

    private String prenom;

    private String adresse;

    private String telephone;

    private String email;
}
