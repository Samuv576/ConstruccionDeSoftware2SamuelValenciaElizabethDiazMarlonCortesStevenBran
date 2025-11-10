package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.EmergencyContact;
import Clinic.Clinic.domain.ports.EmergencyContactPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmergencyContactAdapter implements EmergencyContactPort {

    // Simula una base de datos con clave = documento del paciente
    private final Map<String, EmergencyContact> database = new HashMap<>();

    @Override
    public EmergencyContact findByPatientId(String patientDocument) {
        return database.get(patientDocument);
    }

    @Override
    public void save(EmergencyContact contact) {
        // En un sistema real, el contacto estaría vinculado a un paciente
        // Acá asumimos que el documento se gestiona desde el servicio
        // y que el contacto es único por paciente
        String key = extractPatientDocument(contact);
        database.put(key, contact);
    }

    @Override
    public void delete(EmergencyContact contact) {
        String key = extractPatientDocument(contact);
        database.remove(key);
    }

    // Simulación temporal: en un sistema real, el contacto tendría un campo patientDocument
    private String extractPatientDocument(EmergencyContact contact) {
        // ⚠️ Este método es un placeholder. En producción, el modelo debería tener el documento del paciente.
        // Por ahora, usamos el teléfono como identificador temporal (solo para simular)
        return contact.getPhone(); // ⚠️ Esto es solo para la simulación
    }
}
