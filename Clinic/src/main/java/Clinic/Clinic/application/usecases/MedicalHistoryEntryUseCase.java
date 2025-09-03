package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.MedicalHistoryEntry;
import Clinic.Clinic.domain.services.MedicalHistoryEntryService;

import java.time.LocalDate;

public class MedicalHistoryEntryUseCase {

    private final MedicalHistoryEntryService medicalHistoryEntryService;

    public MedicalHistoryEntryUseCase(MedicalHistoryEntryService medicalHistoryEntryService) {
        this.medicalHistoryEntryService = medicalHistoryEntryService;
    }

    public void createMedicalHistoryEntry(String patientDocument, LocalDate date, MedicalHistoryEntry entry) throws Exception {
        medicalHistoryEntryService.create(patientDocument, date, entry);
    }

    public void validateMedicalHistoryEntry(MedicalHistoryEntry entry) throws Exception {
        medicalHistoryEntryService.validateEntryRules(entry);
    }

    public void deleteMedicalHistoryEntry(String patientDocument, LocalDate date) throws Exception {
        medicalHistoryEntryService.delete(patientDocument, date);
    }

    public void updateMedicalHistoryDiagnosis(String patientDocument, LocalDate date, String diagnosis) throws Exception {
        medicalHistoryEntryService.updateDiagnosis(patientDocument, date, diagnosis);
    }
}
