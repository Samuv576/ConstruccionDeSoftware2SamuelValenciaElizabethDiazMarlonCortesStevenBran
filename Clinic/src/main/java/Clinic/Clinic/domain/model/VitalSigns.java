package Clinic.Clinic.domain.model;

public class VitalSigns {
    private double bloodPressure;
    private double temperature;
    private int pulse;
    private double oxygenLevel;
    private Long id;
    private String patientDocument;
    private String vitalSignsDetails;

    public double getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(double bloodPressure) { this.bloodPressure = bloodPressure; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public int getPulse() { return pulse; }
    public void setPulse(int pulse) { this.pulse = pulse; }

    public double getOxygenLevel() { return oxygenLevel; }
    public void setOxygenLevel(double oxygenLevel) { this.oxygenLevel = oxygenLevel; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        this.patientDocument = patientDocument;
    }

    public String getVitalSignsDetails() {
        return vitalSignsDetails;
    }

    public void setVitalSignsDetails(String vitalSignsDetails) {
        this.vitalSignsDetails = vitalSignsDetails;
    }
}
