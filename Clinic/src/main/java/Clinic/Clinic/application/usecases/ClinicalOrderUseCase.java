package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.model.OrderItem;
import Clinic.Clinic.domain.services.ClinicalOrderService;

public class ClinicalOrderUseCase {

    private final ClinicalOrderService clinicalOrderService;

    public ClinicalOrderUseCase(ClinicalOrderService clinicalOrderService) {
        this.clinicalOrderService = clinicalOrderService;
    }


    public void createOrder(ClinicalOrder order) throws Exception {
        clinicalOrderService.create(order);
    }

    public void addItemToOrder(String orderNumber, OrderItem item) throws Exception {
        clinicalOrderService.addItem(orderNumber, item);
    }

    public void removeItemFromOrder(String orderNumber, String itemNumber) throws Exception {
        clinicalOrderService.removeItem(orderNumber, itemNumber);
    }

    public void validateOrder(ClinicalOrder order) throws Exception {
        clinicalOrderService.validateOrder(order);
    }

    public void finalizeOrder(ClinicalOrder order) throws Exception {
        clinicalOrderService.finalizeOrder(order);
    }
}
