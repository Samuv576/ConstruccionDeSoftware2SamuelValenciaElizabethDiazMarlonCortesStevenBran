package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.domain.services.MedicalNoteService;

public class MedicalNoteUseCase {

    private final MedicalNoteService medicalNoteService;

    public MedicalNoteUseCase(MedicalNoteService medicalNoteService) {
        this.medicalNoteService = medicalNoteService;
    }

    public void createMedicalNote(MedicalNote note) throws Exception {
        medicalNoteService.create(note);
    }

    public MedicalNote findMedicalNoteByPatient(long patientId) throws Exception {
        return medicalNoteService.findByPatient(patientId);
    }

    public void deleteMedicalNote(MedicalNote note) throws Exception {
        medicalNoteService.delete(note);
    }

    public void updateMedicalNote(MedicalNote note) throws Exception {
        medicalNoteService.updateNote(note);
    }
}
