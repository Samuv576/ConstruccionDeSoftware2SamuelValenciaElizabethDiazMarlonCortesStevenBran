package Clinic.Clinic.domain.model;

import java.time.LocalDateTime;

public class MedicalNote {
    private long id;
    private Patient patient;
    private User doctor;
    private String note;
    private LocalDateTime dateTime;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public User getDoctor() { return doctor; }
    public void setDoctor(User doctor) { this.doctor = doctor; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}
