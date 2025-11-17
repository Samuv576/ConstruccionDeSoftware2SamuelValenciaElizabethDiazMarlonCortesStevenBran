package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.MedicalHistory;
import Clinic.Clinic.domain.ports.MedicalHistoryPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MedicalHistoryAdapter implements MedicalHistoryPort {


    private final Map<String, MedicalHistory> database = new HashMap<>();

    @Override
    public MedicalHistory findByPatientDocument(String document) {
        return database.get(document);
    }

    @Override
    public void save(MedicalHistory history) {
        database.put(history.getPatientDocument(), history);
    }

    @Override
    public void delete(MedicalHistory history) {
        database.remove(history.getPatientDocument());
    }
}
