package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.MedicalHistoryValidator;
import Clinic.Clinic.domain.model.MedicalHistory;
import Clinic.Clinic.domain.model.MedicalHistoryEntry;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
public class MedicalHistoryBuilder {

    private final MedicalHistoryValidator validator;

    public MedicalHistoryBuilder(MedicalHistoryValidator validator) {
        this.validator = validator;
    }

    public MedicalHistory build(String patientDocumentStr, Map<LocalDate, MedicalHistoryEntry> entries) throws Exception {
        String patientDocument = validator.validatePatientDocument(patientDocumentStr);

        if (entries != null) {
            for (Map.Entry<LocalDate, MedicalHistoryEntry> entry : entries.entrySet()) {
                validator.validateEntry(entry.getValue());
            }
        }

        MedicalHistory history = new MedicalHistory();
        history.setPatientDocument(patientDocument);
        history.setEntries(entries);

        return history;
    }
}
