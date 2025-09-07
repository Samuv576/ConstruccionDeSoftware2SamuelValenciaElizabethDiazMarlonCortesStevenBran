package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.InventoryItemValidator;
import Clinic.Clinic.domain.model.InventoryItem;
import org.springframework.stereotype.Component;

@Component
public class InventoryItemBuilder {

    private final InventoryItemValidator validator;

    public InventoryItemBuilder(InventoryItemValidator validator) {
        this.validator = validator;
    }

    public InventoryItem build(String idStr, String nameStr, String typeStr) throws Exception {
        String id = validator.validateId(idStr);
        String name = validator.validateName(nameStr);
        String type = validator.validateType(typeStr);

        InventoryItem item = new InventoryItem();
        item.setId(id);
        item.setName(name);
        item.setType(type);

        return item;
    }
}
