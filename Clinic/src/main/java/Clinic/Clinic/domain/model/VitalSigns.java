package Clinic.Clinic.domain.model;

public class VitalSigns {
    private String bloodPressure;
    private double temperature;
    private int pulse;
    private int heartRate;
    private double oxygenLevel;
    private double weight;
    private Long id;
    private String patientDocument;
    private String vitalSignsDetails;

    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public int getPulse() { return pulse; }
    public void setPulse(int pulse) { this.pulse = pulse; }

    public int getHeartRate() { return heartRate; }
    public void setHeartRate(int heartRate) { this.heartRate = heartRate; }

    public double getOxygenLevel() { return oxygenLevel; }
    public void setOxygenLevel(double oxygenLevel) { this.oxygenLevel = oxygenLevel; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

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
