package Clinic.Clinic.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnostic_aid_order_items")
public class DiagnosticAidOrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String itemDetails;

    // Add other fields based on DiagnosticAidOrderItem model

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }
}