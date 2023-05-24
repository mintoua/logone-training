package logonedigital.springcourse.validators;

import logonedigital.springcourse.dtos.CoursDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CoursValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CoursDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CoursDto coursDto = (CoursDto) target;

        // Validation du nom
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "field.required", "Le nom du cours est requis.");

        // Validation de la description
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required", "La description du cours est requise.");

        // Validation des dates de début et de fin
        if (coursDto.getDateDebut() == null) {
            errors.rejectValue("dateDebut", "field.required", "La date de début du cours est requise.");
        }
        if (coursDto.getDateFin() == null) {
            errors.rejectValue("dateFin", "field.required", "La date de fin du cours est requise.");
        } else if (coursDto.getDateDebut() != null && coursDto.getDateFin().isBefore(coursDto.getDateDebut())) {
            errors.rejectValue("dateFin", "field.invalid", "La date de fin du cours doit être après la date de début.");
        }
    }
}
