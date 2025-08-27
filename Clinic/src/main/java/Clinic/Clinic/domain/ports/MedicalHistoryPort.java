package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.MedicalHistory;

public interface MedicalHistoryPort {
    MedicalHistory findByPatientDocument(String document) throws Exception;
    void save(MedicalHistory history) throws Exception;
    void delete(MedicalHistory history) throws Exception;
}
