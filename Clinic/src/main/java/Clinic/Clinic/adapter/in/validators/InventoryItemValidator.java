package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class InventoryItemValidator extends SimpleValidator {

    public String validateId(String value) throws Exception {
        return stringValidator("ID del ítem de inventario", value);
    }

    public String validateName(String value) throws Exception {
        return stringValidator("nombre del ítem", value);
    }

    public String validateType(String value) throws Exception {
        return stringValidator("tipo del ítem", value);
    }
}
