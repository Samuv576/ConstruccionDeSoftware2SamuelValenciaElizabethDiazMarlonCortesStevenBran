package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class SpecialistTypeValidator extends SimpleValidator {

    public String validateId(String value) throws Exception {
        return stringValidator("ID del tipo de especialista", value);
    }

    public String validateName(String value) throws Exception {
        return stringValidator("nombre del tipo de especialista", value);
    }
}
