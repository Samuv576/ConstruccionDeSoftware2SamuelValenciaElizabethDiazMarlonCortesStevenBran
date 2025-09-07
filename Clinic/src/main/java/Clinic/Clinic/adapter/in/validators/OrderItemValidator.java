package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class OrderItemValidator extends SimpleValidator {

    public String validateItemNumber(String value) throws Exception {
        return stringValidator("número de ítem", value);
    }

    public String validateType(String value) throws Exception {
        return stringValidator("tipo de ítem", value);
    }

    public String validateReferenceId(String value) throws Exception {
        return stringValidator("ID de referencia", value);
    }
}
