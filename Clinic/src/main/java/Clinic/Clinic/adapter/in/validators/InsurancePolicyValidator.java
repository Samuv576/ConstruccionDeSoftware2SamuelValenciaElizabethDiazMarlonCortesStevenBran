package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InsurancePolicyValidator extends SimpleValidator {

    public String validateCompanyName(String value) throws Exception {
        return stringValidator("nombre de la compañía aseguradora", value);
    }

    public String validatePolicyNumber(String value) throws Exception {
        return stringValidator("número de póliza", value);
    }

    public boolean validateActiveStatus(String value) throws Exception {
        return booleanValidator("estado activo de la póliza", value);
    }

    public LocalDate validateEndDate(String value) throws Exception {
        try {
            LocalDate date = LocalDate.parse(value);
            if (date.isBefore(LocalDate.now())) {
                throw new Exception("La fecha de vigencia debe ser futura");
            }
            return date;
        } catch (Exception e) {
            throw new Exception("La fecha ingresada no tiene un formato válido (yyyy-MM-dd)");
        }
    }
}
