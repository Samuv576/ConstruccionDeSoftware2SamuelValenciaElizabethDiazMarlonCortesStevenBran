package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.MedicalHistory;
import Clinic.Clinic.domain.services.MedicalHistoryService;
import org.springframework.stereotype.Component;

@Component
public class MedicalHistoryUseCase {

    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryUseCase(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    public void createMedicalHistory(MedicalHistory history) throws Exception {
        medicalHistoryService.create(history);
    }

    public MedicalHistory getHistory(String patientDocument) throws Exception {
        return medicalHistoryService.getHistory(patientDocument);
    }

    public void deleteMedicalHistory(MedicalHistory history) throws Exception {
        medicalHistoryService.delete(history);
    }
}
