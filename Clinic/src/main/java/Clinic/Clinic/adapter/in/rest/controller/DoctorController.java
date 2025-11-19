package Clinic.Clinic.adapter.in.rest.controller;

import Clinic.Clinic.adapter.in.rest.request.*;
import Clinic.Clinic.application.exceptions.BusinessException;
import Clinic.Clinic.application.exceptions.InputsException;
import Clinic.Clinic.application.usecases.*;
import Clinic.Clinic.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private ClinicalRecordUseCase clinicalRecordUseCase;

    @Autowired
    private MedicalHistoryUseCase medicalHistoryUseCase;

    // ClinicalRecord endpoints
    @PostMapping("/clinical-records/{patientDocument}")
    public ResponseEntity<?> createClinicalRecord(@PathVariable String patientDocument, @RequestBody ClinicalRecordRequest request) {
        try {
            ClinicalRecord record = new ClinicalRecord();
            record.setRecordDetails(request.getRecordDetails());
            // Set medicalNote, clinicalOrder, vitalSigns with proper retrieval if needed

            clinicalRecordUseCase.createClinicalRecord(record, patientDocument);
            return ResponseEntity.status(HttpStatus.CREATED).body(record);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/clinical-records/{patientDocument}")
    public ResponseEntity<?> getClinicalRecordByPatient(@PathVariable String patientDocument) {
        try {
            return ResponseEntity.ok(clinicalRecordUseCase.findClinicalRecord(patientDocument));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // MedicalHistory endpoints
    @PostMapping("/medical-histories")
    public ResponseEntity<?> createMedicalHistory(@RequestBody MedicalHistoryRequest request) {
        try {
            MedicalHistory history = new MedicalHistory();
            history.setPatientDocument(request.getPatientDocument());
            history.setPatientName(request.getPatientName());
            history.setHistoryDetails(request.getHistoryDetails());

            medicalHistoryUseCase.createMedicalHistory(history);
            return ResponseEntity.status(HttpStatus.CREATED).body(history);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/medical-histories/{patientDocument}/entries")
    public ResponseEntity<?> getMedicalHistoryEntries(@PathVariable String patientDocument) {
        try {
            return ResponseEntity.ok(medicalHistoryUseCase.getHistoryEntries(patientDocument));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
