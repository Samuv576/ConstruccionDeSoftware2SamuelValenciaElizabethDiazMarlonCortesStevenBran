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


    private String extractPatientDocument(ClinicalRecord record) {


        return record.getClinicalOrder() != null ? record.getClinicalOrder().getOrderNumber() : "unknown";
    }


    private static class ClinicalRecordWrapper {
        String patientDocument;
        ClinicalRecord record;

        ClinicalRecordWrapper(String patientDocument, ClinicalRecord record) {
            this.patientDocument = patientDocument;
            this.record = record;
        }
    }
}
