package logonedigital.springcourse.dtos;

import logonedigital.springcourse.entities.Enseignant;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EnseignantDto {

    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;

    public EnseignantDto fromEntity(Enseignant enseignant){

        if(enseignant == null){
            // TODO Throw an exception
            return null;
        }

        return EnseignantDto.builder()
                .id(enseignant.getId())
                .nom(enseignant.getNom())
                .prenom(enseignant.getPrenom())
                .adresse(enseignant.getAdresse())
                .telephone(enseignant.getTelephone())
                .email(enseignant.getEmail())
                .build();
    }

    public Enseignant toEntity(EnseignantDto enseignantDto){

        if(enseignantDto == null){
            // TODO Throw an exception
            return null;
        }

        return Enseignant.builder()
                .id(enseignantDto.getId())
                .nom(enseignantDto.getNom())
                .prenom(enseignantDto.getPrenom())
                .adresse(enseignantDto.getAdresse())
                .telephone(enseignantDto.getTelephone())
                .email(enseignantDto.getEmail())
                .build();
    }
}
