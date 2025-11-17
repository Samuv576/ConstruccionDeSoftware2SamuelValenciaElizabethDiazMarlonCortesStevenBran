package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.EmergencyContact;
import Clinic.Clinic.domain.ports.EmergencyContactPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmergencyContactAdapter implements EmergencyContactPort {


    private final Map<String, EmergencyContact> database = new HashMap<>();

    @Override
    public EmergencyContact findByPatientId(String patientDocument) {
        return database.get(patientDocument);
    }

    @Override
    public void save(EmergencyContact contact) {



        String key = extractPatientDocument(contact);
        database.put(key, contact);
    }

    @Override
    public void delete(EmergencyContact contact) {
        String key = extractPatientDocument(contact);
        database.remove(key);
    }


    private String extractPatientDocument(EmergencyContact contact) {


        return contact.getPhone();
    }
}
