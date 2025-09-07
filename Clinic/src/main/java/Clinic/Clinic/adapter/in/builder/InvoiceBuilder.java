package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.InvoiceValidator;
import Clinic.Clinic.domain.model.Invoice;
import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.domain.model.InsurancePolicy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InvoiceBuilder {

    private final InvoiceValidator validator;

    public InvoiceBuilder(InvoiceValidator validator) {
        this.validator = validator;
    }

    public Invoice build(String patientIdStr, String policyNumberStr, String amountStr, String descriptionStr, String dateTimeStr) throws Exception {
        long patientId = validator.validatePatientId(patientIdStr);
        String policyNumber = validator.validatePolicyNumber(policyNumberStr);
        double amount = validator.validateAmount(amountStr);
        String description = validator.validateDescription(descriptionStr);
        LocalDateTime dateTime = validator.validateDateTime(dateTimeStr);

        Patient patient = new Patient();
        patient.setId(patientId);

        InsurancePolicy policy = new InsurancePolicy();
        policy.setPolicyNumber(policyNumber);

        Invoice invoice = new Invoice();
        invoice.setPatient(patient);
        invoice.setInsurancePolicy(policy);
        invoice.setAmount(amount);
        invoice.setDescription(description);
        invoice.setDateTime(dateTime);

        return invoice;
    }
}
