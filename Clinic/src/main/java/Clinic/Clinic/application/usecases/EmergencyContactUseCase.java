package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.EmergencyContact;
import Clinic.Clinic.domain.services.EmergencyContactService;

public class EmergencyContactUseCase {

    private final EmergencyContactService emergencyContactService;

    public EmergencyContactUseCase(EmergencyContactService emergencyContactService) {
        this.emergencyContactService = emergencyContactService;
    }

    public void createEmergencyContact(EmergencyContact contact, String patientDocument) throws Exception {
        emergencyContactService.create(contact, patientDocument);
    }

    public void updateEmergencyContact(EmergencyContact contact, String patientDocument) throws Exception {
        emergencyContactService.update(contact, patientDocument);
    }

    public EmergencyContact findEmergencyContact(String patientDocument) throws Exception {
        return emergencyContactService.findByPatient(patientDocument);
    }

    public void deleteEmergencyContact(String patientDocument) throws Exception {
        emergencyContactService.delete(patientDocument);
    }
}
