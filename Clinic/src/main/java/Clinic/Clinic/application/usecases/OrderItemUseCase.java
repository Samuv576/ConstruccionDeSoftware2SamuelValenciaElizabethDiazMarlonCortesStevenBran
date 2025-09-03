package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.OrderItem;
import Clinic.Clinic.domain.services.OrderItemService;

import java.util.List;

public class OrderItemUseCase {

    private final OrderItemService orderItemService;

    public OrderItemUseCase(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    public void createOrderItem(OrderItem item) throws Exception {
        orderItemService.create(item);
    }

    public void validateOrderItemUniqueness(OrderItem item) throws Exception {
        orderItemService.validateItemUniqueness(item);
    }

    public List<OrderItem> findOrderItemsByType(String type) throws Exception {
        return orderItemService.findByType(type);
    }

    public void deleteOrderItem(OrderItem item) throws Exception {
        orderItemService.delete(item);
    }
}
