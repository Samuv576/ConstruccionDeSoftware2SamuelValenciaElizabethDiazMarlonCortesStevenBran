package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.OrderItem;
import Clinic.Clinic.domain.ports.OrderItemPort;

import java.util.List;

public class OrderItemService {

    private final OrderItemPort orderItemPort;

    public OrderItemService(OrderItemPort orderItemPort) {
        this.orderItemPort = orderItemPort;
    }

    public void create(OrderItem item) throws Exception {
        validateItemUniqueness(item);

        if (item.getItemNumber() == null || item.getItemNumber().isEmpty()) {
            throw new Exception("El número de ítem es obligatorio");
        }

        if (item.getType() == null || item.getType().isEmpty()) {
            throw new Exception("El tipo de ítem es obligatorio");
        }

        if (item.getReferenceId() == null || item.getReferenceId().isEmpty()) {
            throw new Exception("El ID de referencia es obligatorio");
        }

        orderItemPort.save(item);
    }


    public void validateItemUniqueness(OrderItem item) throws Exception {
        OrderItem existing = orderItemPort.findByItemNumber(item.getItemNumber());
        if (existing != null) {
            throw new Exception("Ya existe un ítem con ese número");
        }
    }


    public List<OrderItem> findByType(String type) throws Exception {
        throw new UnsupportedOperationException("findByType debe implementarse en el adaptador");
    }


    public void delete(OrderItem item) throws Exception {
        OrderItem existing = orderItemPort.findByItemNumber(item.getItemNumber());
        if (existing == null) {
            throw new Exception("No se encontró el ítem para eliminar");
        }

        orderItemPort.delete(item);
    }
}
