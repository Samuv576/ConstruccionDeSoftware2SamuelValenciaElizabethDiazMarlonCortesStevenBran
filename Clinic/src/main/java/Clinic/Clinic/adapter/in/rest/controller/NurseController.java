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
@RequestMapping("/api/nurse")
public class NurseController {

    @Autowired
    private VitalSignsUseCase vitalSignsUseCase;

    @Autowired
    private MedicalNoteUseCase medicalNoteUseCase;

    @Autowired
    private PatientUseCase patientUseCase;

    @Autowired
    private UserUseCase userUseCase;

    // VitalSigns endpoints
    @PostMapping("/vital-signs/{patientDocument}")
    public ResponseEntity<?> createVitalSigns(@PathVariable String patientDocument, @RequestBody VitalSignsRequest request) {
        try {
        VitalSigns vitalSigns = new VitalSigns();
        vitalSigns.setBloodPressure(request.getBloodPressure());
        vitalSigns.setTemperature(request.getTemperature());
        vitalSigns.setPulse(request.getPulse());
        vitalSigns.setHeartRate(request.getHeartRate());
        vitalSigns.setOxygenLevel(request.getOxygenLevel());
        vitalSigns.setWeight(request.getWeight());
        vitalSigns.setPatientDocument(request.getPatientDocument());
        vitalSigns.setVitalSignsDetails(request.getVitalSignsDetails());            vitalSignsUseCase.createVitalSigns(vitalSigns, patientDocument);
            return ResponseEntity.status(HttpStatus.CREATED).body(vitalSigns);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/vital-signs/{patientDocument}")
    public ResponseEntity<?> getVitalSignsByPatient(@PathVariable String patientDocument) {
        try {
            return ResponseEntity.ok(vitalSignsUseCase.findVitalSignsByPatient(patientDocument));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // MedicalNote endpoints
    @PostMapping("/medical-notes")
    public ResponseEntity<?> createMedicalNote(@RequestBody MedicalNoteRequest request) {
        try {
            MedicalNote note = new MedicalNote();
            note.setPatientDocument(request.getPatientDocument());
            note.setDoctorDocument(request.getDoctorDocument());
            note.setConsultationDate(request.getConsultationDate());
            note.setConsultationReason(request.getConsultationReason());
            note.setSymptoms(request.getSymptoms());
            note.setDiagnosis(request.getDiagnosis());
            note.setNotes(request.getNotes());

            // Fetch patient and doctor
            Patient patient = patientUseCase.findPatientByDocument(request.getPatientDocument());
            User doctor = userUseCase.findUserByDocument(request.getDoctorDocument());
            note.setPatient(patient);
            note.setDoctor(doctor);

            medicalNoteUseCase.createMedicalNote(note);
            return ResponseEntity.status(HttpStatus.CREATED).body(note);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/medical-notes/{patientId}")
    public ResponseEntity<?> getMedicalNoteByPatient(@PathVariable long patientId) {
        try {
            return ResponseEntity.ok(medicalNoteUseCase.findMedicalNoteByPatient(patientId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
