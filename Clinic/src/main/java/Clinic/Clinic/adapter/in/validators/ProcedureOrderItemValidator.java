package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class ProcedureOrderItemValidator extends SimpleValidator {

    public String validateId(String value) throws Exception {
        return stringValidator("ID del ítem de procedimiento", value);
    }

    public int validateQuantity(String value) throws Exception {
        int quantity = intValidator("cantidad del procedimiento", value);
        if (quantity <= 0) {
            throw new Exception("La cantidad debe ser mayor a cero");
        }
        return quantity;
    }

    public String validateFrequency(String value) throws Exception {
        return stringValidator("frecuencia del procedimiento", value);
    }

    public boolean validateRequiresSpecialist(String value) throws Exception {
        return booleanValidator("requiere especialista", value);
    }

    public String validateSpecialistTypeId(String value, boolean requiresSpecialist) throws Exception {
        if (requiresSpecialist) {
            return stringValidator("ID del tipo de especialista", value);
        }
        return value != null ? value : "";
    }

    public String validateItemNumber(String value) throws Exception {
        return stringValidator("número de ítem", value);
    }
}
