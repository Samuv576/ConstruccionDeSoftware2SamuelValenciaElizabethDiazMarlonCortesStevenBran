package Clinic.Clinic.domain.model;

import java.util.List;

public class ClinicalOrder {
    private String orderNumber;
    private List<OrderItem> items;

    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}
