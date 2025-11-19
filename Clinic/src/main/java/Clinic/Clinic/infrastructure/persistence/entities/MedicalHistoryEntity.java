package Clinic.Clinic.infrastructure.persistence.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medical_histories")
public class MedicalHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String patientDocument;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "general_observations", columnDefinition = "TEXT")
    private String generalObservations;

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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getGeneralObservations() {
        return generalObservations;
    }

    public void setGeneralObservations(String generalObservations) {
        this.generalObservations = generalObservations;
    }
}