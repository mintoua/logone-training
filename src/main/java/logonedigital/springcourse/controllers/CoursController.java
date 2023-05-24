package logonedigital.springcourse.controllers;

import jakarta.validation.Valid;
import logonedigital.springcourse.dtos.CoursDto;
import logonedigital.springcourse.services.interfaces.ICoursService;
import logonedigital.springcourse.validators.CoursValidator;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cours")
@AllArgsConstructor
@Validated // Annotation pour activer la validation
public class CoursController {

    private final ICoursService coursService;
    private final CoursValidator coursValidator;

    @InitBinder // Méthode pour associer le validator au contrôleur
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(coursValidator);
    }

    // Build Add Cours REST API
    // http://localhost:8080/api/v1/cours/add
    @PostMapping(value = "/add", consumes = "application/json")
    public CoursDto addCours(@RequestBody @Valid CoursDto coursDto) {
        return coursService.addCours(coursDto);
    }

    @PutMapping("/{id}")
    public CoursDto updateCours(@PathVariable Long id, @RequestBody @Valid CoursDto coursDto) {
        coursDto.setId(id);
        return coursService.updateCours(coursDto);
    }


}
