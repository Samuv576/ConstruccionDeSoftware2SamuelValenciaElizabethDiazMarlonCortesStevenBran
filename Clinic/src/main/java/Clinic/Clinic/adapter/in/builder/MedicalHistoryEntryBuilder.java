package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.MedicalHistoryEntryValidator;
import Clinic.Clinic.domain.model.DiagnosticAidOrderItem;
import Clinic.Clinic.domain.model.MedicalHistoryEntry;
import Clinic.Clinic.domain.model.MedicationOrderItem;
import Clinic.Clinic.domain.model.ProcedureOrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicalHistoryEntryBuilder {

    private final MedicalHistoryEntryValidator validator;

    public MedicalHistoryEntryBuilder(MedicalHistoryEntryValidator validator) {
        this.validator = validator;
    }

    public MedicalHistoryEntry build(
            String doctorDocumentStr,
            String reasonStr,
            String symptomsStr,
            String diagnosisStr,
            List<MedicationOrderItem> medications,
            List<ProcedureOrderItem> procedures,
            DiagnosticAidOrderItem diagnosticAid
    ) throws Exception {
        String doctorDocument = validator.validateDoctorDocument(doctorDocumentStr);
        String reason = validator.validateReason(reasonStr);
        String symptoms = validator.validateSymptoms(symptomsStr);
        String diagnosis = (diagnosticAid == null) ? validator.validateDiagnosis(diagnosisStr) : null;

        MedicalHistoryEntry entry = new MedicalHistoryEntry();
        entry.setDoctorDocument(doctorDocument);
        entry.setReason(reason);
        entry.setSymptoms(symptoms);
        entry.setDiagnosis(diagnosis);
        entry.setMedications(medications);
        entry.setProcedures(procedures);
        entry.setDiagnosticAid(diagnosticAid);

        validator.validateEntryRules(entry);
        return entry;
    }
}
