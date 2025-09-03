package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.MedicalHistory;
import Clinic.Clinic.domain.model.MedicalHistoryEntry;
import Clinic.Clinic.domain.ports.MedicalHistoryPort;

import java.time.LocalDate;
import java.util.Map;

public class MedicalHistoryService {

    private final MedicalHistoryPort medicalHistoryPort;

    public MedicalHistoryService(MedicalHistoryPort medicalHistoryPort) {
        this.medicalHistoryPort = medicalHistoryPort;
    }

    // Crear historial médico
    public void create(MedicalHistory history) throws Exception {
        if (history.getPatientDocument() == null || history.getPatientDocument().isEmpty()) {
            throw new Exception("El documento del paciente es obligatorio");
        }

        MedicalHistory existing = medicalHistoryPort.findByPatientDocument(history.getPatientDocument());
        if (existing != null) {
            throw new Exception("Ya existe un historial médico para este paciente");
        }

        medicalHistoryPort.save(history);
    }

    public void addEntry(String patientDocument, LocalDate date, MedicalHistoryEntry entry) throws Exception {
        MedicalHistory history = medicalHistoryPort.findByPatientDocument(patientDocument);
        if (history == null) {
            throw new Exception("No se encontró historial médico para el paciente");
        }

        Map<LocalDate, MedicalHistoryEntry> entries = history.getEntries();
        if (entries.containsKey(date)) {
            throw new Exception("Ya existe una entrada para esa fecha");
        }

        entries.put(date, entry);
        medicalHistoryPort.save(history);
    }

    public Map<LocalDate, MedicalHistoryEntry> getEntries(String patientDocument) throws Exception {
        MedicalHistory history = medicalHistoryPort.findByPatientDocument(patientDocument);
        if (history == null) {
            throw new Exception("No se encontró historial médico para el paciente");
        }

        return history.getEntries();
    }


    public void deleteEntry(String patientDocument, LocalDate date) throws Exception {
        MedicalHistory history = medicalHistoryPort.findByPatientDocument(patientDocument);
        if (history == null) {
            throw new Exception("No se encontró historial médico para el paciente");
        }

        Map<LocalDate, MedicalHistoryEntry> entries = history.getEntries();
        if (!entries.containsKey(date)) {
            throw new Exception("No existe una entrada para esa fecha");
        }

        entries.remove(date);
        medicalHistoryPort.save(history);
    }
}
