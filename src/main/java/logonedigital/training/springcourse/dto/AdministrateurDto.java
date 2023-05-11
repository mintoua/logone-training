package logonedigital.training.springcourse.dto;

import jakarta.persistence.Column;
import logonedigital.training.springcourse.entities.Administrateur;
import logonedigital.training.springcourse.entities.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdministrateurDto {

    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;

    public AdministrateurDto fromEntity(Administrateur admin){

        if(admin == null){
            // TODO Throw an exception
            return null;
        }

        return AdministrateurDto.builder()
                .id(admin.getId())
                .nom(admin.getNom())
                .prenom(admin.getPrenom())
                .adresse(admin.getAdresse())
                .telephone(admin.getTelephone())
                .email(admin.getEmail())
                .build();
    }

    public Administrateur toEntity(AdministrateurDto adminDto){

        if(adminDto == null){
            // TODO Throw an exception
            return null;
        }

        return Administrateur.builder()
                .nom(adminDto.getNom())
                .prenom(adminDto.getPrenom())
                .adresse(adminDto.getAdresse())
                .telephone(adminDto.getTelephone())
                .email(adminDto.getEmail())
                .build();
    }
}
