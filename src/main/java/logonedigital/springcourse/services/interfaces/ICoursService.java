package logonedigital.springcourse.services.interfaces;

import logonedigital.springcourse.dtos.CoursDto;


import java.util.List;

public interface ICoursService {

    List <CoursDto> getAllCours();

    CoursDto addCours(CoursDto coursDto);

    void deleteCoursWithId(Long idCours);

    CoursDto updateCours(CoursDto coursDto);

    CoursDto getCoursById(CoursDto coursDto);
}
