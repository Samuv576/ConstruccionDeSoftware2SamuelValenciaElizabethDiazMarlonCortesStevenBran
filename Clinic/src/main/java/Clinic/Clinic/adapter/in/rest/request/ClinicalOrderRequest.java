package Clinic.Clinic.adapter.in.rest.request;

public class ClinicalOrderRequest {
    private String orderDetails;
    private String orderNumber;

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
