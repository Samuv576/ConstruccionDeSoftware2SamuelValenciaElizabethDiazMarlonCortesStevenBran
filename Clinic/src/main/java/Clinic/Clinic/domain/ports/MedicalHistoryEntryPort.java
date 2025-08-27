package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.MedicalHistoryEntry;

public interface MedicalHistoryEntryPort {
    MedicalHistoryEntry findByDate(String patientDocument, java.time.LocalDate date) throws Exception;
    void save(MedicalHistoryEntry entry) throws Exception;
    void delete(MedicalHistoryEntry entry) throws Exception;
}
