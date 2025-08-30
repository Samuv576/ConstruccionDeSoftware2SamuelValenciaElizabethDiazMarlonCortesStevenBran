package Clinic.Clinic.domain.model;

import java.time.LocalDateTime;

public class Invoice {
    private long id;
    private Patient patient;
    private InsurancePolicy insurancePolicy;
    private double amount;
    private String description;
    private LocalDateTime dateTime;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public InsurancePolicy getInsurancePolicy() { return insurancePolicy; }
    public void setInsurancePolicy(InsurancePolicy insurancePolicy) { this.insurancePolicy = insurancePolicy; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}
