package Clinic.Clinic.adapter.in.rest.request;

public class MedicalHistoryRequest {
    private String patientDocument;
    private String patientName;
    private String historyDetails;

    public String getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        this.patientDocument = patientDocument;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getHistoryDetails() {
        return historyDetails;
    }

    public void setHistoryDetails(String historyDetails) {
        this.historyDetails = historyDetails;
    }
}
