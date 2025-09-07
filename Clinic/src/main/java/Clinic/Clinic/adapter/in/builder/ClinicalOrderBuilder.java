package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.ClinicalOrderValidator;
import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.model.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClinicalOrderBuilder {

    private final ClinicalOrderValidator validator;

    public ClinicalOrderBuilder(ClinicalOrderValidator validator) {
        this.validator = validator;
    }

    public ClinicalOrder build(String orderNumberStr, List<OrderItem> items) throws Exception {
        String orderNumber = validator.validateOrderNumber(orderNumberStr);
        validator.validateItems(items);

        ClinicalOrder order = new ClinicalOrder();
        order.setOrderNumber(orderNumber);
        order.setItems(items);

        return order;
    }
}
