package Clinic.Clinic.domain.model;

import java.time.LocalDateTime;

public class MedicalNote {
    private long id;
    private Patient patient;
    private User doctor;
    private String patientDocument;
    private String doctorDocument;
    private LocalDateTime consultationDate;
    private String consultationReason;    // Motivo de la consulta
    private String symptoms;              // Sintomatología
    private String diagnosis;             // Diagnóstico
    private String notes;                 // Observaciones del doctor

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public User getDoctor() { return doctor; }
    public void setDoctor(User doctor) { this.doctor = doctor; }

    public String getPatientDocument() { return patientDocument; }
    public void setPatientDocument(String patientDocument) { this.patientDocument = patientDocument; }

    public String getDoctorDocument() { return doctorDocument; }
    public void setDoctorDocument(String doctorDocument) { this.doctorDocument = doctorDocument; }

    public LocalDateTime getConsultationDate() { return consultationDate; }
    public void setConsultationDate(LocalDateTime consultationDate) { this.consultationDate = consultationDate; }

    public String getConsultationReason() { return consultationReason; }
    public void setConsultationReason(String consultationReason) { this.consultationReason = consultationReason; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
