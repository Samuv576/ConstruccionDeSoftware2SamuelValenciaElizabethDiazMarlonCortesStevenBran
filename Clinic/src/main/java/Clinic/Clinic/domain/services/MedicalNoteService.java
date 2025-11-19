package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.domain.ports.MedicalNotePort;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service

public class MedicalNoteService {

    private final MedicalNotePort medicalNotePort;

    public MedicalNoteService(MedicalNotePort medicalNotePort) {
        this.medicalNotePort = medicalNotePort;
    }


    public void create(MedicalNote note) throws Exception {
        if (note.getPatient() == null || note.getDoctor() == null) {
            throw new Exception("La nota médica debe tener paciente y médico asignados");
        }

        if (note.getConsultationReason() == null || note.getConsultationReason().isEmpty()) {
            throw new Exception("El motivo de consulta no puede estar vacío");
        }

        if (note.getConsultationDate() == null) {
            note.setConsultationDate(LocalDateTime.now());
        }

        medicalNotePort.save(note);
    }


    public MedicalNote findByPatient(long patientId) throws Exception {
        MedicalNote temp = new MedicalNote();
        Patient patient = new Patient();
        patient.setId(patientId);
        temp.setPatient(patient);

        MedicalNote found = medicalNotePort.findById(temp);
        if (found == null) {
            throw new Exception("No se encontró nota médica para el paciente");
        }

        return found;
    }


    public void delete(MedicalNote note) throws Exception {
        MedicalNote existing = medicalNotePort.findById(note);
        if (existing == null) {
            throw new Exception("No se encontró la nota médica para eliminar");
        }

        medicalNotePort.delete(note);
    }


    public void updateNote(MedicalNote note) throws Exception {
        MedicalNote existing = medicalNotePort.findById(note);
        if (existing == null) {
            throw new Exception("No se encontró la nota médica para actualizar");
        }

        if (note.getNotes() == null || note.getNotes().isEmpty()) {
            throw new Exception("Las observaciones no pueden estar vacías");
        }

        existing.setNotes(note.getNotes());
        existing.setConsultationDate(LocalDateTime.now());

        medicalNotePort.save(existing);
    }
}
