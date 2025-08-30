package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.domain.ports.PatientPort;

public class PatientService {

    private final PatientPort patientPort;

    public PatientService(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void create(Patient patient) throws Exception {
        Patient existing = patientPort.findByDocument(patient);

        if (existing != null) {
            throw new Exception("Ya existe un paciente registrado con esos datos");
        }

        patientPort.save(patient);
    }
}
