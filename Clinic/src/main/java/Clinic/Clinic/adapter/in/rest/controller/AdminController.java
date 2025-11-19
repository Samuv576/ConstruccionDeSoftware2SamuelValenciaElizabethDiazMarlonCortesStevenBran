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

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private PatientUseCase patientUseCase;

    @Autowired
    private AppointmentUseCase appointmentUseCase;

    @Autowired
    private UserUseCase userUseCase;

    @Autowired
    private InvoiceUseCase invoiceUseCase;

    @Autowired
    private InsurancePolicyUseCase insurancePolicyUseCase;

    @Autowired
    private EmergencyContactUseCase emergencyContactUseCase;

    // Patient endpoints
    @PostMapping("/patients")
    public ResponseEntity<?> createPatient(@RequestBody PatientRequest request) {
        try {
            Patient patient = new Patient();
            patient.setFullName(request.getFullName());
            patient.setDocument(request.getDocument());
            patient.setPhone(request.getPhone());
            patient.setAddress(request.getAddress());
            
            // Parse gender
            if (request.getGender() != null) {
                patient.setGender(Clinic.Clinic.domain.model.enums.Gender.valueOf(request.getGender()));
            }
            
            // Parse dateOfBirth
            if (request.getDateOfBirth() != null) {
                patient.setDateOfBirth(java.time.LocalDate.parse(request.getDateOfBirth()));
            }

            patientUseCase.createPatient(patient);
            return ResponseEntity.status(HttpStatus.CREATED).body(patient);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/patients/{document}")
    public ResponseEntity<?> getPatientByDocument(@PathVariable String document) {
        try {
            return ResponseEntity.ok(patientUseCase.findPatientByDocument(document));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Appointment endpoints
    @PostMapping("/appointments")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentRequest request) {
        try {
            // Fetch patient and doctor
            Patient patient = patientUseCase.findPatientByDocument(request.getPatientDocument());
            User doctor = userUseCase.findUserByDocument(request.getDoctorDocument());
            
            Appointment appointment = new Appointment();
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
            appointment.setPatientDocument(request.getPatientDocument());
            appointment.setDoctorDocument(request.getDoctorDocument());
            appointment.setReason(request.getReason());
            
            // Parse dateTime
            if (request.getDateTime() != null) {
                appointment.setDateTime(java.time.LocalDateTime.parse(request.getDateTime()));
            }

            appointmentUseCase.createAppointment(appointment);
            return ResponseEntity.status(HttpStatus.CREATED).body(appointment);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<?> cancelAppointment(@PathVariable long id) {
        try {
            Appointment appointment = new Appointment();
            appointment.setId(id);
            appointmentUseCase.cancelAppointment(appointment);
            return ResponseEntity.ok("Appointment cancelled successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Invoice endpoints
    @PostMapping("/invoices")
    public ResponseEntity<?> createInvoice(@RequestBody InvoiceRequest request) {
        try {
            Invoice invoice = new Invoice();
            invoice.setAmount(request.getAmount());
            invoice.setDescription(request.getDescription());
            invoice.setInvoiceNumber(request.getInvoiceNumber());
            invoice.setPatientDocument(request.getPatientDocument());
            invoice.setStatus(request.getStatus());
            
            // Parse dates
            if (request.getIssueDate() != null && !request.getIssueDate().isEmpty()) {
                invoice.setIssueDate(LocalDate.parse(request.getIssueDate()));
            }
            if (request.getDueDate() != null && !request.getDueDate().isEmpty()) {
                invoice.setDueDate(LocalDate.parse(request.getDueDate()));
            }
            
            // Get patient by document
            if (request.getPatientDocument() != null) {
                Patient patient = patientUseCase.findPatientByDocument(request.getPatientDocument());
                invoice.setPatient(patient);
            }

            invoiceUseCase.createInvoice(invoice);
            return ResponseEntity.status(HttpStatus.CREATED).body(invoice);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Additional invoice operations can be added here as needed

    // InsurancePolicy endpoints
    @PostMapping("/insurance-policies")
    public ResponseEntity<?> createInsurancePolicy(@RequestBody InsurancePolicyRequest request) {
        try {
            InsurancePolicy policy = new InsurancePolicy();
            policy.setCompanyName(request.getCompanyName());
            policy.setPolicyNumber(request.getPolicyNumber());
            policy.setActive(request.isActive());
            policy.setProvider(request.getProvider());
            policy.setPatientDocument(request.getPatientDocument());
            
            // Parse endDate
            if (request.getEndDate() != null && !request.getEndDate().isEmpty()) {
                policy.setEndDate(LocalDate.parse(request.getEndDate()));
            }

            insurancePolicyUseCase.createPolicy(policy);
            return ResponseEntity.status(HttpStatus.CREATED).body(policy);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/insurance-policies/{policyNumber}")
    public ResponseEntity<?> getInsurancePolicyByNumber(@PathVariable String policyNumber) {
        try {
            return ResponseEntity.ok(insurancePolicyUseCase.findPolicyByNumber(policyNumber));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // EmergencyContact endpoints
    @PostMapping("/emergency-contacts/{patientDocument}")
    public ResponseEntity<?> createEmergencyContact(@PathVariable String patientDocument, @RequestBody EmergencyContactRequest request) {
        try {
            EmergencyContact contact = new EmergencyContact();
            contact.setFirstName(request.getFirstName());
            contact.setLastName(request.getLastName());
            contact.setRelationship(request.getRelationship());
            contact.setPhone(request.getPhone());
            contact.setPatientDocument(patientDocument);

            emergencyContactUseCase.createEmergencyContact(contact, patientDocument);
            return ResponseEntity.status(HttpStatus.CREATED).body(contact);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/emergency-contacts/{patientDocument}")
    public ResponseEntity<?> getEmergencyContactByPatient(@PathVariable String patientDocument) {
        try {
            return ResponseEntity.ok(emergencyContactUseCase.findEmergencyContact(patientDocument));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
