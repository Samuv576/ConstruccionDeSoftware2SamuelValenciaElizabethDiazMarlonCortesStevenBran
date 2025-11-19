package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.MedicalHistory;
import Clinic.Clinic.domain.ports.MedicalHistoryPort;

import org.springframework.stereotype.Service;

@Service
public class MedicalHistoryService {

    private final MedicalHistoryPort medicalHistoryPort;

    public MedicalHistoryService(MedicalHistoryPort medicalHistoryPort) {
        this.medicalHistoryPort = medicalHistoryPort;
    }

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

    public MedicalHistory getHistory(String patientDocument) throws Exception {
        MedicalHistory history = medicalHistoryPort.findByPatientDocument(patientDocument);
        if (history == null) {
            throw new Exception("No se encontró historial médico para el paciente");
        }
        return history;
    }

    public void delete(MedicalHistory history) throws Exception {
        MedicalHistory existing = medicalHistoryPort.findByPatientDocument(history.getPatientDocument());
        if (existing == null) {
            throw new Exception("No se encontró el historial médico para eliminar");
        }
        medicalHistoryPort.delete(history);
    }
}
