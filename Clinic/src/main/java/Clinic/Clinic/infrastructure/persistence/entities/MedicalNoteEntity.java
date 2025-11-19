package Clinic.Clinic.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_notes")
public class MedicalNoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String note;

    // Add other relevant fields as needed

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
