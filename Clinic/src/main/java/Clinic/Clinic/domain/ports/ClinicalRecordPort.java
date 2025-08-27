package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.ClinicalRecord;

public interface ClinicalRecordPort {
    ClinicalRecord findByPatientId(String patientDocument) throws Exception;
    void save(ClinicalRecord record) throws Exception;
    void delete(ClinicalRecord record) throws Exception;
}
