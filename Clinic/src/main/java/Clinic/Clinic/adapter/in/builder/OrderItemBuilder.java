package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.OrderItemValidator;
import Clinic.Clinic.domain.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemBuilder {

    private final OrderItemValidator validator;

    public OrderItemBuilder(OrderItemValidator validator) {
        this.validator = validator;
    }

    public OrderItem build(String itemNumberStr, String typeStr, String referenceIdStr) throws Exception {
        String itemNumber = validator.validateItemNumber(itemNumberStr);
        String type = validator.validateType(typeStr);
        String referenceId = validator.validateReferenceId(referenceIdStr);

        OrderItem item = new OrderItem();
        item.setItemNumber(itemNumber);
        item.setType(type);
        item.setReferenceId(referenceId);

        return item;
    }
}
