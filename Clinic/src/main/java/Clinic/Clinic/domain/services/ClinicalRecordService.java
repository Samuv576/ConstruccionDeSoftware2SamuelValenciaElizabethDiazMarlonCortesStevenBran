package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.ClinicalRecord;
import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.model.VitalSigns;
import Clinic.Clinic.domain.ports.ClinicalRecordPort;

public class ClinicalRecordService {

    private final ClinicalRecordPort clinicalRecordPort;

    public ClinicalRecordService(ClinicalRecordPort clinicalRecordPort) {
        this.clinicalRecordPort = clinicalRecordPort;
    }


    public void create(ClinicalRecord record, String patientDocument) throws Exception {
        ClinicalRecord existing = clinicalRecordPort.findByPatientId(patientDocument);
        if (existing != null) {
            throw new Exception("Ya existe un registro clínico para este paciente");
        }
        clinicalRecordPort.save(record);
    }


    public ClinicalRecord findByPatient(String patientDocument) throws Exception {
        ClinicalRecord record = clinicalRecordPort.findByPatientId(patientDocument);
        if (record == null) {
            throw new Exception("No se encontró el registro clínico del paciente");
        }
        return record;
    }


    public void updateVitalSigns(String patientDocument, VitalSigns signs) throws Exception {
        ClinicalRecord record = clinicalRecordPort.findByPatientId(patientDocument);
        if (record == null) {
            throw new Exception("No se encontró el registro clínico para actualizar signos vitales");
        }
        record.setVitalSigns(signs);
        clinicalRecordPort.save(record);
    }


    public void attachOrder(String patientDocument, ClinicalOrder order) throws Exception {
        ClinicalRecord record = clinicalRecordPort.findByPatientId(patientDocument);
        if (record == null) {
            throw new Exception("No se encontró el registro clínico para adjuntar la orden");
        }
        record.setClinicalOrder(order);
        clinicalRecordPort.save(record);
    }
}
