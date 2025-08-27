package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.Patient;

public interface PatientPort {
    Patient findByDocument(Patient patient) throws Exception;
    Patient findByName(Patient patient) throws Exception;
    void save(Patient patient) throws Exception;
    void delete(Patient patient) throws Exception;
}
