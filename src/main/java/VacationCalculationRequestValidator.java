import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class VacationCalculationRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return VacationCalculationRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "averageSalary", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vacationDays", "field.required");

        VacationCalculationRequest request = (VacationCalculationRequest) target;

        if (request.getAverageSalary() != null && request.getAverageSalary().compareTo(BigDecimal.ZERO) <= 0) {
            errors.rejectValue("averageSalary", "field.invalid");
        }

        if (request.getVacationDays() <= 0) {
            errors.rejectValue("vacationDays", "field.invalid");
        }
    }
}
