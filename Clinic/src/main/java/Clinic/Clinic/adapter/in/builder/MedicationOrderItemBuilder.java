package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.MedicationOrderItemValidator;
import Clinic.Clinic.domain.model.MedicationOrderItem;
import org.springframework.stereotype.Component;

@Component
public class MedicationOrderItemBuilder {

    private final MedicationOrderItemValidator validator;

    public MedicationOrderItemBuilder(MedicationOrderItemValidator validator) {
        this.validator = validator;
    }

    public MedicationOrderItem build(String idStr, String doseStr, String durationStr, String itemNumberStr) throws Exception {
        String id = validator.validateId(idStr);
        String dose = validator.validateDose(doseStr);
        int durationDays = validator.validateDurationDays(durationStr);
        String itemNumber = validator.validateItemNumber(itemNumberStr);

        MedicationOrderItem item = new MedicationOrderItem();
        item.setId(id);
        item.setDose(dose);
        item.setDurationDays(durationDays);
        item.setItemNumber(itemNumber);

        return item;
    }
}
