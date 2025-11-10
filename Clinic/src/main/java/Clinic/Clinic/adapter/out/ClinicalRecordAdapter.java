package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.ClinicalRecord;
import Clinic.Clinic.domain.ports.ClinicalRecordPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClinicalRecordAdapter implements ClinicalRecordPort {

    private final List<ClinicalRecordWrapper> database = new ArrayList<>();

    @Override
    public ClinicalRecord findByPatientId(String patientDocument) {
        return database.stream()
                .filter(wrapper -> wrapper.patientDocument.equals(patientDocument))
                .map(wrapper -> wrapper.record)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(ClinicalRecord record) {
        String patientDocument = extractPatientDocument(record);
        ClinicalRecord existing = findByPatientId(patientDocument);
        if (existing != null) {
            database.removeIf(wrapper -> wrapper.patientDocument.equals(patientDocument));
        }
        database.add(new ClinicalRecordWrapper(patientDocument, record));
    }

    @Override
    public void delete(ClinicalRecord record) {
        String patientDocument = extractPatientDocument(record);
        database.removeIf(wrapper -> wrapper.patientDocument.equals(patientDocument));
    }

    // Simulación de cómo se obtiene el documento del paciente desde el record
    private String extractPatientDocument(ClinicalRecord record) {
        // Este método debe extraer el documento del paciente desde alguna parte del record
        // Por ahora lo dejamos como un placeholder
        return record.getClinicalOrder() != null ? record.getClinicalOrder().getOrderNumber() : "unknown";
    }

    // Clase interna para asociar el record con el documento del paciente
    private static class ClinicalRecordWrapper {
        String patientDocument;
        ClinicalRecord record;

        ClinicalRecordWrapper(String patientDocument, ClinicalRecord record) {
            this.patientDocument = patientDocument;
            this.record = record;
        }
    }
}
