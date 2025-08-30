package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.model.OrderItem;
import Clinic.Clinic.domain.ports.ClinicalOrderPort;

public class ClinicalOrderService {

    private final ClinicalOrderPort clinicalOrderPort;

    public ClinicalOrderService(ClinicalOrderPort clinicalOrderPort) {
        this.clinicalOrderPort = clinicalOrderPort;
    }


    public void create(ClinicalOrder order) throws Exception {
        ClinicalOrder existing = clinicalOrderPort.findById(order.getOrderNumber());
        if (existing != null) {
            throw new Exception("Ya existe una orden con ese número");
        }

        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new Exception("La orden debe contener al menos un ítem");
        }

        clinicalOrderPort.save(order);
    }


    public void addItem(String orderNumber, OrderItem item) throws Exception {
        ClinicalOrder order = clinicalOrderPort.findById(orderNumber);
        if (order == null) {
            throw new Exception("No se encontró la orden clínica");
        }

        boolean duplicate = order.getItems().stream()
            .anyMatch(existing -> existing.getItemNumber().equals(item.getItemNumber()));

        if (duplicate) {
            throw new Exception("Ya existe un ítem con ese número en la orden");
        }

        order.getItems().add(item);
        clinicalOrderPort.save(order);
    }


    public void removeItem(String orderNumber, String itemNumber) throws Exception {
        ClinicalOrder order = clinicalOrderPort.findById(orderNumber);
        if (order == null) {
            throw new Exception("No se encontró la orden clínica");
        }

        boolean removed = order.getItems().removeIf(item -> item.getItemNumber().equals(itemNumber));
        if (!removed) {
            throw new Exception("No se encontró el ítem en la orden");
        }

        clinicalOrderPort.save(order);
    }


    public void validateOrder(ClinicalOrder order) throws Exception {
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new Exception("La orden debe tener al menos un ítem");
        }

        for (OrderItem item : order.getItems()) {
            if (item.getItemNumber() == null || item.getItemNumber().isEmpty()) {
                throw new Exception("Cada ítem debe tener un número válido");
            }
        }
    }


    public void finalizeOrder(ClinicalOrder order) throws Exception {
        validateOrder(order);

        clinicalOrderPort.save(order);
    }
}
