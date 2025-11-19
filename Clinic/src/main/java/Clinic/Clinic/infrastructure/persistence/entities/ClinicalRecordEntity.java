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

    @Column(name = "medical_note_id")
    private Long medicalNoteId;

    @Column(name = "clinical_order_id")
    private Long clinicalOrderId;

    @Column(name = "vital_signs_id")
    private Long vitalSignsId;

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

    public Long getMedicalNoteId() {
        return medicalNoteId;
    }

    public void setMedicalNoteId(Long medicalNoteId) {
        this.medicalNoteId = medicalNoteId;
    }

    public Long getClinicalOrderId() {
        return clinicalOrderId;
    }

    public void setClinicalOrderId(Long clinicalOrderId) {
        this.clinicalOrderId = clinicalOrderId;
    }

    public Long getVitalSignsId() {
        return vitalSignsId;
    }

    public void setVitalSignsId(Long vitalSignsId) {
        this.vitalSignsId = vitalSignsId;
    }
}