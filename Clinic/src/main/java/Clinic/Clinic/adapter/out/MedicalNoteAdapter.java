package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.domain.ports.MedicalNotePort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MedicalNoteAdapter implements MedicalNotePort {

    // Simulación de base de datos en memoria
    private final Map<Long, MedicalNote> database = new HashMap<>();

    @Override
    public MedicalNote findById(MedicalNote note) {
        if (note.getPatient() == null) return null;
        long patientId = note.getPatient().getId();
        return database.get(patientId);
    }

    @Override
    public void save(MedicalNote note) {
        long patientId = note.getPatient().getId();
        database.put(patientId, note);
    }

    @Override
    public void delete(MedicalNote note) {
        long patientId = note.getPatient().getId();
        database.remove(patientId);
    }
}
