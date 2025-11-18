package Clinic.Clinic.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "clinical_records")
public class ClinicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String recordDetails;

    // Add other fields based on ClinicalRecord model

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordDetails() {
        return recordDetails;
    }

    public void setRecordDetails(String recordDetails) {
        this.recordDetails = recordDetails;
    }
}