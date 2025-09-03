package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.domain.services.PatientService;

public class PatientUseCase {

    private final PatientService patientService;

    public PatientUseCase(PatientService patientService) {
        this.patientService = patientService;
    }

    public void createPatient(Patient patient) throws Exception {
        patientService.create(patient);
    }

    public Patient findPatientByDocument(String document) throws Exception {
        return patientService.findByDocument(document);
    }

    public void updatePatientContactInfo(Patient patient) throws Exception {
        patientService.updateContactInfo(patient);
    }

    public void deletePatient(Patient patient) throws Exception {
        patientService.delete(patient);
    }
}
