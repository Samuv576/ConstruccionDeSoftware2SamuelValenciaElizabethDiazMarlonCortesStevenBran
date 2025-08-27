package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.OrderItem;

public interface OrderItemPort {
    OrderItem findByItemNumber(String itemNumber) throws Exception;
    void save(OrderItem item) throws Exception;
    void delete(OrderItem item) throws Exception;
}
