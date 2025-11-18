package Clinic.Clinic.domain.model;

public class ClinicalRecord {
    private Long id;
    private MedicalNote medicalNote;
    private ClinicalOrder clinicalOrder;
    private VitalSigns vitalSigns;
    private String recordDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicalNote getMedicalNote() {
        return medicalNote;
    }

    public void setMedicalNote(MedicalNote medicalNote) {
        this.medicalNote = medicalNote;
    }

    public ClinicalOrder getClinicalOrder() {
        return clinicalOrder;
    }

    public void setClinicalOrder(ClinicalOrder clinicalOrder) {
        this.clinicalOrder = clinicalOrder;
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public String getRecordDetails() {
        return recordDetails;
    }

    public void setRecordDetails(String recordDetails) {
        this.recordDetails = recordDetails;
    }
}
