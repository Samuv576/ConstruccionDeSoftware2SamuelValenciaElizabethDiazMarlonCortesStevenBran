package Clinic.Clinic.adapter.in.rest.request;

public class ClinicalRecordRequest {
    private Long medicalNoteId;
    private Long clinicalOrderId;
    private Long vitalSignsId;
    private String recordDetails;

    public Long getMedicalNoteId() {
        return medicalNoteId;
    }

    public void setMedicalNoteId(Long medicalNoteId) {
        this.medicalNoteId = medicalNoteId;
    }

    public Long getClinicalOrderId() {
        return clinicalOrderId;
    }

    public void setClinicalOrderId(Long clinicalOrderId) {
        this.clinicalOrderId = clinicalOrderId;
    }

    public Long getVitalSignsId() {
        return vitalSignsId;
    }

    public void setVitalSignsId(Long vitalSignsId) {
        this.vitalSignsId = vitalSignsId;
    }

    public String getRecordDetails() {
        return recordDetails;
    }

    public void setRecordDetails(String recordDetails) {
        this.recordDetails = recordDetails;
    }
}
