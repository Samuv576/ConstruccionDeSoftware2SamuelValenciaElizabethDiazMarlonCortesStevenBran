package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.domain.ports.PatientPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PatientAdapter implements PatientPort {


    private final Map<Long, Patient> database = new HashMap<>();

    @Override
    public Patient findByDocument(Patient patient) {
        return database.get(patient.getId());
    }

    @Override
    public Patient findByName(Patient patient) {
        return database.values().stream()
                .filter(p -> p.getFullName().equalsIgnoreCase(patient.getFullName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Patient patient) {
        database.put(patient.getId(), patient);
    }

    @Override
    public void delete(Patient patient) {
        database.remove(patient.getId());
    }
}
