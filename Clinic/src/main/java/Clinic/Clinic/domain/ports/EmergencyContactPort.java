package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.EmergencyContact;

public interface EmergencyContactPort {
    EmergencyContact findByPatientId(String patientDocument) throws Exception;
    void save(EmergencyContact contact) throws Exception;
    void delete(EmergencyContact contact) throws Exception;
}
