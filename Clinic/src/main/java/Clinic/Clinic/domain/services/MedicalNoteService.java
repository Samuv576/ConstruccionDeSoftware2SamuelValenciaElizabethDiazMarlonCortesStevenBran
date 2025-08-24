package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.domain.ports.MedicalNotePort;

public class MedicalNoteService {

    private final MedicalNotePort medicalNotePort;

    public MedicalNoteService(MedicalNotePort medicalNotePort) {
        this.medicalNotePort = medicalNotePort;
    }

    public void create(MedicalNote note) throws Exception {
        MedicalNote existing = medicalNotePort.findById(note);

        if (existing != null) {
            throw new Exception("Ya existe una nota médica registrada con esos datos");
        }

        medicalNotePort.save(note);
    }
}
