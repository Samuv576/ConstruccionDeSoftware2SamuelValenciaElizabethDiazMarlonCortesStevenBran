package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.ProcedureOrderItemValidator;
import Clinic.Clinic.domain.model.ProcedureOrderItem;
import org.springframework.stereotype.Component;

@Component
public class ProcedureOrderItemBuilder {

    private final ProcedureOrderItemValidator validator;

    public ProcedureOrderItemBuilder(ProcedureOrderItemValidator validator) {
        this.validator = validator;
    }

    public ProcedureOrderItem build(
            String idStr,
            String quantityStr,
            String frequencyStr,
            String requiresSpecialistStr,
            String specialistTypeIdStr,
            String itemNumberStr
    ) throws Exception {
        String id = validator.validateId(idStr);
        int quantity = validator.validateQuantity(quantityStr);
        String frequency = validator.validateFrequency(frequencyStr);
        boolean requiresSpecialist = validator.validateRequiresSpecialist(requiresSpecialistStr);
        String specialistTypeId = validator.validateSpecialistTypeId(specialistTypeIdStr, requiresSpecialist);
        String itemNumber = validator.validateItemNumber(itemNumberStr);

        ProcedureOrderItem item = new ProcedureOrderItem();
        item.setId(id);
        item.setQuantity(quantity);
        item.setFrequency(frequency);
        item.setRequiresSpecialist(requiresSpecialist);
        item.setSpecialistTypeId(specialistTypeId);
        item.setItemNumber(itemNumber);

        return item;
    }
}
