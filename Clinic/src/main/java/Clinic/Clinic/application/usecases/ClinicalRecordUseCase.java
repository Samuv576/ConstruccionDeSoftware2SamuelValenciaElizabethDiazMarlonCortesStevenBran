package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.model.ClinicalRecord;
import Clinic.Clinic.domain.model.VitalSigns;
import Clinic.Clinic.domain.services.ClinicalRecordService;

public class ClinicalRecordUseCase {

    private final ClinicalRecordService clinicalRecordService;

    public ClinicalRecordUseCase(ClinicalRecordService clinicalRecordService) {
        this.clinicalRecordService = clinicalRecordService;
    }

    public void createRecord(ClinicalRecord record, String patientDocument) throws Exception {
        clinicalRecordService.create(record, patientDocument);
    }

    public ClinicalRecord findByPatient(String patientDocument) throws Exception {
        return clinicalRecordService.findByPatient(patientDocument);
    }

    public void updateVitalSigns(String patientDocument, VitalSigns signs) throws Exception {
        clinicalRecordService.updateVitalSigns(patientDocument, signs);
    }

    public void attachOrder(String patientDocument, ClinicalOrder order) throws Exception {
        clinicalRecordService.attachOrder(patientDocument, order);
    }
}