package logonedigital.springcourse.dtos;

import logonedigital.springcourse.entities.Cours;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CoursDto {

    private Long id;
    private String nom;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public static CoursDto toDto(Cours cours){

        if (cours == null){
            // TODO Throw an exception
            return null;
        }

        return CoursDto.builder()
                .id(cours.getId())
                .nom(cours.getNom())
                .description(cours.getDescription())
                .dateDebut(cours.getDateDebut())
                .dateFin(cours.getDateFin())
                .build();
    }


    public static Cours toEntity( CoursDto coursDto ){

        if (coursDto == null){
            // TODO Throw an exception
            return null;
        }

        return Cours.builder()
                .id(coursDto.getId())
                .nom(coursDto.getNom())
                .description(coursDto.getDescription())
                .dateDebut(coursDto.getDateDebut())
                .dateFin(coursDto.getDateFin())
                .build();
    }
}

