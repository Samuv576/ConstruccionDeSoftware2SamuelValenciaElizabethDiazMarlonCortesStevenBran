package Clinic.Clinic.domain.model;

import java.util.List;

public class MedicalHistoryEntry {
    private String doctorDocument;
    private String reason;
    private String symptoms;
    private String diagnosis;
    private List<MedicationOrderItem> medications;
    private List<ProcedureOrderItem> procedures;
    private DiagnosticAidOrderItem diagnosticAid;

    public String getDoctorDocument() { return doctorDocument; }
    public void setDoctorDocument(String doctorDocument) { this.doctorDocument = doctorDocument; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public List<MedicationOrderItem> getMedications() { return medications; }
    public void setMedications(List<MedicationOrderItem> medications) { this.medications = medications; }

    public List<ProcedureOrderItem> getProcedures() { return procedures; }
    public void setProcedures(List<ProcedureOrderItem> procedures) { this.procedures = procedures; }

    public DiagnosticAidOrderItem getDiagnosticAid() { return diagnosticAid; }
    public void setDiagnosticAid(DiagnosticAidOrderItem diagnosticAid) { this.diagnosticAid = diagnosticAid; }
}
