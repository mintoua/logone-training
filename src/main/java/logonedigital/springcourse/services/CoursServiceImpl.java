package logonedigital.springcourse.services;

import logonedigital.springcourse.dtos.CoursDto;
import logonedigital.springcourse.entities.Cours;
import logonedigital.springcourse.repositories.CoursRepository;
import logonedigital.springcourse.services.interfaces.ICoursService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CoursServiceImpl implements ICoursService {

    final CoursRepository coursRepository;

    @Override
    public CoursDto addCours(CoursDto coursDto) {

        System.out.println(CoursDto.toEntity(coursDto).toString());
        return CoursDto
                .toDto(coursRepository.save(CoursDto.toEntity(coursDto)));
    }

    @Override
    public List<CoursDto> getAllCours() {
        // TODO Handling Exception Here Before

        return coursRepository.findAll()
                .stream()
                .map(CoursDto::toDto)
                .collect(Collectors.toList());
    }



    @Override
    public void deleteCoursWithId(Long idCours) {
        coursRepository.deleteById(idCours);
    }

    @Override
    public CoursDto updateCours(CoursDto coursDto) {
        // TODO Handling Exception Here before

        Cours cours = coursRepository
                .findById(coursDto.getId())
                .orElse(null);
        assert cours != null;
        cours.setNom(coursDto.getNom());
        cours.setDescription(coursDto.getDescription());
        cours.setDateFin(coursDto.getDateFin());
        cours.setDateDebut(coursDto.getDateDebut());

        return CoursDto
                .toDto(coursRepository.save(cours));
    }

    @Override
    public CoursDto getCoursById(CoursDto coursDto) {

        Cours cours = coursRepository
                        .findById(coursDto.getId())
                        .orElse(null);
        log.info("Cours :" +cours);
        return CoursDto.toDto(cours);
    }
}
