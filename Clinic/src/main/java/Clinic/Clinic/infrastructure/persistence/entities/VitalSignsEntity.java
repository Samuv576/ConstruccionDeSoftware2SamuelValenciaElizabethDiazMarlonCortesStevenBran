package Clinic.Clinic.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vital_signs")
public class VitalSignsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String patientDocument;

    @Column(nullable = false)
    private String vitalSignsDetails;

    // Add other fields based on VitalSigns model

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        this.patientDocument = patientDocument;
    }

    public String getVitalSignsDetails() {
        return vitalSignsDetails;
    }

    public void setVitalSignsDetails(String vitalSignsDetails) {
        this.vitalSignsDetails = vitalSignsDetails;
    }
}