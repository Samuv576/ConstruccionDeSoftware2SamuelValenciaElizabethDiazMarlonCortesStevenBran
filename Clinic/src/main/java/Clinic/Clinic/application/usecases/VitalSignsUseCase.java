package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.VitalSigns;
import Clinic.Clinic.domain.services.VitalSignsService;

public class VitalSignsUseCase {

    private final VitalSignsService vitalSignsService;

    public VitalSignsUseCase(VitalSignsService vitalSignsService) {
        this.vitalSignsService = vitalSignsService;
    }

    public void createVitalSigns(VitalSigns signs, String patientDocument) throws Exception {
        vitalSignsService.create(signs, patientDocument);
    }

    public VitalSigns findVitalSignsByPatient(String patientDocument) throws Exception {
        return vitalSignsService.findByPatient(patientDocument);
    }

    public void updateVitalSigns(VitalSigns signs, String patientDocument) throws Exception {
        vitalSignsService.update(signs, patientDocument);
    }

    public void deleteVitalSigns(String patientDocument) throws Exception {
        vitalSignsService.delete(patientDocument);
    }

    public void validateVitalSigns(VitalSigns signs) throws Exception {
        vitalSignsService.validateSigns(signs);
    }
}