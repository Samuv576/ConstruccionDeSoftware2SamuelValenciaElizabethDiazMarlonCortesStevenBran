package Clinic.Clinic.adapter.in.validators;

import Clinic.Clinic.domain.model.MedicalHistoryEntry;
import Clinic.Clinic.domain.model.MedicationOrderItem;
import Clinic.Clinic.domain.model.ProcedureOrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicalHistoryEntryValidator extends SimpleValidator {

    public String validateDoctorDocument(String value) throws Exception {
        if (value == null || value.length() > 10) {
            throw new Exception("La cédula del médico es obligatoria y debe tener máximo 10 dígitos");
        }
        return value;
    }

    public String validateReason(String value) throws Exception {
        return stringValidator("motivo de la consulta", value);
    }

    public String validateSymptoms(String value) throws Exception {
        return stringValidator("síntomas", value);
    }

    public String validateDiagnosis(String value) throws Exception {
        return stringValidator("diagnóstico", value);
    }

    public void validateEntryRules(MedicalHistoryEntry entry) throws Exception {
        boolean hasDiagnosticAid = entry.getDiagnosticAid() != null;
        boolean hasMedications = entry.getMedications() != null && !entry.getMedications().isEmpty();
        boolean hasProcedures = entry.getProcedures() != null && !entry.getProcedures().isEmpty();

        if (hasDiagnosticAid && (hasMedications || hasProcedures)) {
            throw new Exception("No se pueden recetar medicamentos ni procedimientos junto con una ayuda diagnóstica");
        }

        if (!hasDiagnosticAid && (entry.getDiagnosis() == null || entry.getDiagnosis().isEmpty())) {
            throw new Exception("Debe registrarse un diagnóstico si no hay ayuda diagnóstica");
        }

        if (hasMedications && hasProcedures) {
            List<MedicationOrderItem> meds = entry.getMedications();
            List<ProcedureOrderItem> procs = entry.getProcedures();
            for (MedicationOrderItem med : meds) {
                for (ProcedureOrderItem proc : procs) {
                    if (med.getItemNumber().equals(proc.getItemNumber())) {
                        throw new Exception("No puede haber dos ítems con el mismo número en la misma orden");
                    }
                }
            }
        }
    }
}
