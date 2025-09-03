package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class DiagnosticAidOrderItemValidator extends SimpleValidator {

    public String validateId(String value) throws Exception {
        return stringValidator("ID del ítem de ayuda diagnóstica", value);
    }

    public String validateItemNumber(String value) throws Exception {
        return stringValidator("número de ítem", value);
    }

    public String validateName(String value) throws Exception {
        return stringValidator("nombre del ítem", value);
    }

    public boolean validateResultAvailable(String value) throws Exception {
        return booleanValidator("disponibilidad del resultado", value);
    }
}
