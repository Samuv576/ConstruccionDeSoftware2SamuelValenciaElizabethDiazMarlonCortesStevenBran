package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.EmergencyContact;
import Clinic.Clinic.domain.ports.EmergencyContactPort;

public class EmergencyContactService {

    private final EmergencyContactPort emergencyContactPort;

    public EmergencyContactService(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }


    public void create(EmergencyContact contact, String patientDocument) throws Exception {
        EmergencyContact existing = emergencyContactPort.findByPatientId(patientDocument);
        if (existing != null) {
            throw new Exception("Ya existe un contacto de emergencia para este paciente");
        }

        validatePhone(contact.getPhone());
        emergencyContactPort.save(contact);
    }


    public void update(EmergencyContact contact, String patientDocument) throws Exception {
        EmergencyContact existing = emergencyContactPort.findByPatientId(patientDocument);
        if (existing == null) {
            throw new Exception("No se encontró contacto de emergencia para actualizar");
        }

        validatePhone(contact.getPhone());
        emergencyContactPort.save(contact);
    }


    public EmergencyContact findByPatient(String patientDocument) throws Exception {
        EmergencyContact contact = emergencyContactPort.findByPatientId(patientDocument);
        if (contact == null) {
            throw new Exception("No se encontró contacto de emergencia para este paciente");
        }
        return contact;
    }


    public void delete(String patientDocument) throws Exception {
        EmergencyContact contact = emergencyContactPort.findByPatientId(patientDocument);
        if (contact == null) {
            throw new Exception("No se encontró contacto de emergencia para eliminar");
        }
        emergencyContactPort.delete(contact);
    }


    private void validatePhone(String phone) throws Exception {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new Exception("El número de teléfono debe tener exactamente 10 dígitos numéricos");
        }
    }
}
