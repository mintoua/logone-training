package logonedigital.springcourse.dtos;

import logonedigital.springcourse.entities.Etudiant;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EtudiantDto {

    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;

    public EtudiantDto fromEntity(Etudiant etudiant){

        if(etudiant == null){
            // TODO Throw an exception
            return null;
        }

        return EtudiantDto.builder()
                .id(etudiant.getId())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .adresse(etudiant.getAdresse())
                .telephone(etudiant.getTelephone())
                .email(etudiant.getEmail())
                .build();
    }

    public Etudiant toEntity(EtudiantDto etudiantDto){

        if(etudiantDto == null){
            // TODO Throw an exception
            return null;
        }

        return Etudiant.builder()
                .id(etudiantDto.getId())
                .nom(etudiantDto.getNom())
                .prenom(etudiantDto.getPrenom())
                .adresse(etudiantDto.getAdresse())
                .telephone(etudiantDto.getTelephone())
                .email(etudiantDto.getEmail())
                .build();
    }
}
