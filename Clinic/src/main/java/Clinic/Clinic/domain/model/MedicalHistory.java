package Clinic.Clinic.domain.model;

import java.time.LocalDate;
import java.util.Map;

public class MedicalHistory {
    private String patientDocument;
    private Map<LocalDate, MedicalHistoryEntry> entries;

    public String getPatientDocument() { return patientDocument; }
    public void setPatientDocument(String patientDocument) { this.patientDocument = patientDocument; }

    public Map<LocalDate, MedicalHistoryEntry> getEntries() { return entries; }
    public void setEntries(Map<LocalDate, MedicalHistoryEntry> entries) { this.entries = entries; }
}
