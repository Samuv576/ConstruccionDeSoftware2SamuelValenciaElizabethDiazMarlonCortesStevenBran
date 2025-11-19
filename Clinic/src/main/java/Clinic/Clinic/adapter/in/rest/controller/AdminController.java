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
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private PatientUseCase patientUseCase;

    @Autowired
    private AppointmentUseCase appointmentUseCase;

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
            // Set gender and dateOfBirth with proper parsing if needed

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
            Appointment appointment = new Appointment();
            appointment.setReason(request.getReason());
            // Set patient, doctor, dateTime with proper parsing if needed

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
            // Set patient, insurancePolicy, dateTime with proper parsing if needed

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
            // Set endDate with proper parsing if needed

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
