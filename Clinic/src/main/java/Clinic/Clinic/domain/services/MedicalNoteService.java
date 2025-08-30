package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.domain.ports.MedicalNotePort;

import java.time.LocalDateTime;

public class MedicalNoteService {

    private final MedicalNotePort medicalNotePort;

    public MedicalNoteService(MedicalNotePort medicalNotePort) {
        this.medicalNotePort = medicalNotePort;
    }


    public void create(MedicalNote note) throws Exception {
        if (note.getPatient() == null || note.getDoctor() == null) {
            throw new Exception("La nota médica debe tener paciente y médico asignados");
        }

        if (note.getNote() == null || note.getNote().isEmpty()) {
            throw new Exception("El contenido de la nota médica no puede estar vacío");
        }

        if (note.getDateTime() == null) {
            note.setDateTime(LocalDateTime.now());
        }

        medicalNotePort.save(note);
    }


    public MedicalNote findByPatient(long patientId) throws Exception {
        // Simulación: se usa un objeto temporal para buscar por ID
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

        if (note.getNote() == null || note.getNote().isEmpty()) {
            throw new Exception("La nota médica no puede estar vacía");
        }

        existing.setNote(note.getNote());
        existing.setDateTime(LocalDateTime.now());

        medicalNotePort.save(existing);
    }
}
