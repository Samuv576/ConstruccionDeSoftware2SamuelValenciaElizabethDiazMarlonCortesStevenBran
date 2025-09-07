package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.DiagnosticAidOrderItemValidator;
import Clinic.Clinic.domain.model.DiagnosticAidOrderItem;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticAidOrderItemBuilder {

    private final DiagnosticAidOrderItemValidator validator;

    public DiagnosticAidOrderItemBuilder(DiagnosticAidOrderItemValidator validator) {
        this.validator = validator;
    }

    public DiagnosticAidOrderItem build(String idStr, String nameStr, String resultAvailableStr, String itemNumberStr) throws Exception {
        String id = validator.validateId(idStr);
        String name = validator.validateName(nameStr);
        boolean resultAvailable = validator.validateResultAvailable(resultAvailableStr);
        String itemNumber = validator.validateItemNumber(itemNumberStr);

        DiagnosticAidOrderItem item = new DiagnosticAidOrderItem();
        item.setId(id);
        item.setName(name);
        item.setResultAvailable(resultAvailable);
        item.setItemNumber(itemNumber);

        return item;
    }
}
