package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.VitalSigns;
import Clinic.Clinic.domain.ports.VitalSignsPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VitalSignsAdapter implements VitalSignsPort {


    private final Map<String, VitalSigns> database = new HashMap<>();

    @Override
    public VitalSigns findByPatientId(String patientDocument) {
        return database.get(patientDocument);
    }

    @Override
    public void save(VitalSigns vitalSigns) {



        database.put(tempDocumentHolder, vitalSigns);
    }

    @Override
    public void delete(VitalSigns vitalSigns) {
        database.values().removeIf(v -> v.equals(vitalSigns));
    }


    private String tempDocumentHolder;

    public void setTempDocument(String document) {
        this.tempDocumentHolder = document;
    }
}
