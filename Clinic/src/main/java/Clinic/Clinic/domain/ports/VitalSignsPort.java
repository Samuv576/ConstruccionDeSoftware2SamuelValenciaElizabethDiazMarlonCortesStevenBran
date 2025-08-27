package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.VitalSigns;

public interface VitalSignsPort {
    VitalSigns findByPatientId(String patientDocument) throws Exception;
    void save(VitalSigns vitalSigns) throws Exception;
    void delete(VitalSigns vitalSigns) throws Exception;
}
