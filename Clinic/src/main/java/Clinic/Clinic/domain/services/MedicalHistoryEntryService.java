package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.MedicalHistoryEntry;
import Clinic.Clinic.domain.model.MedicationOrderItem;
import Clinic.Clinic.domain.model.ProcedureOrderItem;
import Clinic.Clinic.domain.model.DiagnosticAidOrderItem;
import Clinic.Clinic.domain.ports.MedicalHistoryEntryPort;

import java.time.LocalDate;

public class MedicalHistoryEntryService {

    private final MedicalHistoryEntryPort medicalHistoryEntryPort;

    public MedicalHistoryEntryService(MedicalHistoryEntryPort medicalHistoryEntryPort) {
        this.medicalHistoryEntryPort = medicalHistoryEntryPort;
    }


    public void create(String patientDocument, LocalDate date, MedicalHistoryEntry entry) throws Exception {
        validateEntryRules(entry);

        MedicalHistoryEntry existing = medicalHistoryEntryPort.findByDate(patientDocument, date);
        if (existing != null) {
            throw new Exception("Ya existe una entrada para esa fecha");
        }

        medicalHistoryEntryPort.save(entry);
    }


    public void validateEntryRules(MedicalHistoryEntry entry) throws Exception {
        boolean hasDiagnosticAid = entry.getDiagnosticAid() != null;
        boolean hasMedications = entry.getMedications() != null && !entry.getMedications().isEmpty();
        boolean hasProcedures = entry.getProcedures() != null && !entry.getProcedures().isEmpty();

        if (hasDiagnosticAid && (hasMedications || hasProcedures)) {
            throw new Exception("No se pueden recetar medicamentos ni procedimientos junto con una ayuda diagnóstica");
        }

        if (!hasDiagnosticAid && entry.getDiagnosis() == null) {
            throw new Exception("Debe registrarse un diagnóstico si no hay ayuda diagnóstica");
        }

        if (entry.getDoctorDocument() == null || entry.getDoctorDocument().length() > 10) {
            throw new Exception("La cédula del médico es obligatoria y debe tener máximo 10 dígitos");
        }


        if (hasMedications && hasProcedures) {
            for (MedicationOrderItem med : entry.getMedications()) {
                for (ProcedureOrderItem proc : entry.getProcedures()) {
                    if (med.getItemNumber().equals(proc.getItemNumber())) {
                        throw new Exception("No puede haber dos ítems con el mismo número en la misma orden");
                    }
                }
            }
        }
    }


    public void delete(String patientDocument, LocalDate date) throws Exception {
        MedicalHistoryEntry entry = medicalHistoryEntryPort.findByDate(patientDocument, date);
        if (entry == null) {
            throw new Exception("No se encontró entrada para eliminar");
        }

        medicalHistoryEntryPort.delete(entry);
    }


    public void updateDiagnosis(String patientDocument, LocalDate date, String diagnosis) throws Exception {
        MedicalHistoryEntry entry = medicalHistoryEntryPort.findByDate(patientDocument, date);
        if (entry == null) {
            throw new Exception("No se encontró entrada para actualizar diagnóstico");
        }

        entry.setDiagnosis(diagnosis);
        medicalHistoryEntryPort.save(entry);
    }
}
