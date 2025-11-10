package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.VitalSigns;
import Clinic.Clinic.domain.ports.VitalSignsPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VitalSignsAdapter implements VitalSignsPort {

    // Simulación de base de datos en memoria
    private final Map<String, VitalSigns> database = new HashMap<>();

    @Override
    public VitalSigns findByPatientId(String patientDocument) {
        return database.get(patientDocument);
    }

    @Override
    public void save(VitalSigns vitalSigns) {
        // En este ejemplo, asumimos que el documento del paciente ya está vinculado externamente
        // Si querés guardar por documento, deberías extender el modelo para incluirlo
        // Aquí lo simulamos con un campo temporal
        database.put(tempDocumentHolder, vitalSigns);
    }

    @Override
    public void delete(VitalSigns vitalSigns) {
        database.values().removeIf(v -> v.equals(vitalSigns));
    }

    // Campo temporal para simular el documento del paciente
    private String tempDocumentHolder;

    public void setTempDocument(String document) {
        this.tempDocumentHolder = document;
    }
}
