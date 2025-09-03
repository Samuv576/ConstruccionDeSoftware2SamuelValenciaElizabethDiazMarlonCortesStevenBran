package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.MedicalHistory;
import Clinic.Clinic.domain.model.MedicalHistoryEntry;
import Clinic.Clinic.domain.services.MedicalHistoryService;

import java.time.LocalDate;
import java.util.Map;

public class MedicalHistoryUseCase {

    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryUseCase(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    public void createMedicalHistory(MedicalHistory history) throws Exception {
        medicalHistoryService.create(history);
    }

    public void addEntryToHistory(String patientDocument, LocalDate date, MedicalHistoryEntry entry) throws Exception {
        medicalHistoryService.addEntry(patientDocument, date, entry);
    }

    public Map<LocalDate, MedicalHistoryEntry> getHistoryEntries(String patientDocument) throws Exception {
        return medicalHistoryService.getEntries(patientDocument);
    }

    public void deleteEntryFromHistory(String patientDocument, LocalDate date) throws Exception {
        medicalHistoryService.deleteEntry(patientDocument, date);
    }
}
