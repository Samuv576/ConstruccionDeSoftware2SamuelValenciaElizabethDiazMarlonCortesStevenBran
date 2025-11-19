package Clinic.Clinic.domain.model;

import java.time.LocalDate;

public class MedicalHistory {
    private Long id;
    private String patientDocument;
    private LocalDate creationDate;
    private String generalObservations;

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
