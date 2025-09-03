package Clinic.Clinic.adapter.in.validators;

import Clinic.Clinic.domain.model.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClinicalOrderValidator extends SimpleValidator {

    public String validateOrderNumber(String value) throws Exception {
        return stringValidator("número de orden", value);
    }

    public void validateItems(List<OrderItem> items) throws Exception {
        if (items == null || items.isEmpty()) {
            throw new Exception("La orden debe contener al menos un ítem");
        }

        for (OrderItem item : items) {
            if (item.getItemNumber() == null || item.getItemNumber().isEmpty()) {
                throw new Exception("Cada ítem debe tener un número válido");
            }
        }
    }
}
