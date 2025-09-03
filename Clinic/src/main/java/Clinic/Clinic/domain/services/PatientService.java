package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.domain.ports.PatientPort;

import java.time.LocalDate;
import java.time.Period;

public class PatientService {

    private final PatientPort patientPort;

    public PatientService(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void create(Patient patient) throws Exception {
        validatePatientData(patient);

        Patient existing = patientPort.findByDocument(patient);
        if (existing != null) {
            throw new Exception("Ya existe un paciente con ese documento");
        }

        patientPort.save(patient);
    }


    public Patient findByDocument(String document) throws Exception {
        Patient temp = new Patient();
        temp.setId(Long.parseLong(document));
        Patient found = patientPort.findByDocument(temp);

        if (found == null) {
            throw new Exception("No se encontró paciente con ese documento");
        }

        return found;
    }

    public void updateContactInfo(Patient patient) throws Exception {
        Patient existing = patientPort.findByDocument(patient);
        if (existing == null) {
            throw new Exception("No se encontró paciente para actualizar");
        }

        if (patient.getPhone() == null || !patient.getPhone().matches("\\d{10}")) {
            throw new Exception("El número de teléfono debe tener 10 dígitos");
        }

        if (patient.getAddress() == null || patient.getAddress().length() > 30) {
            throw new Exception("La dirección debe tener máximo 30 caracteres");
        }

        existing.setPhone(patient.getPhone());
        existing.setAddress(patient.getAddress());

        patientPort.save(existing);
    }

    public void delete(Patient patient) throws Exception {
        Patient existing = patientPort.findByDocument(patient);
        if (existing == null) {
            throw new Exception("No se encontró paciente para eliminar");
        }

        patientPort.delete(existing);
    }

    private void validatePatientData(Patient patient) throws Exception {
        if (patient.getFullName() == null || patient.getFullName().isEmpty()) {
            throw new Exception("El nombre completo es obligatorio");
        }

        if (patient.getDateOfBirth() == null || calculateAge(patient.getDateOfBirth()) > 150) {
            throw new Exception("La fecha de nacimiento no puede superar los 150 años");
        }

        if (patient.getPhone() == null || !patient.getPhone().matches("\\d{10}")) {
            throw new Exception("El número de teléfono debe tener 10 dígitos");
        }

        if (patient.getAddress() == null || patient.getAddress().length() > 30) {
            throw new Exception("La dirección debe tener máximo 30 caracteres");
        }

        if (patient.getGender() == null) {
            throw new Exception("El género del paciente es obligatorio");
        }
    }


    private int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
