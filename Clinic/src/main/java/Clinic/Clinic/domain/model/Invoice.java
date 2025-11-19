package Clinic.Clinic.domain.model;

import java.time.LocalDateTime;

public class Invoice {
    private long id;
    private Patient patient;
    private String patientDocument;
    private InsurancePolicy insurancePolicy;
    private double amount;
    private String description;
    private String invoiceNumber;
    private String status;
    private java.time.LocalDate issueDate;
    private java.time.LocalDate dueDate;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public String getPatientDocument() { return patientDocument; }
    public void setPatientDocument(String patientDocument) { this.patientDocument = patientDocument; }

    public InsurancePolicy getInsurancePolicy() { return insurancePolicy; }
    public void setInsurancePolicy(InsurancePolicy insurancePolicy) { this.insurancePolicy = insurancePolicy; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public java.time.LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(java.time.LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public java.time.LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(java.time.LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
