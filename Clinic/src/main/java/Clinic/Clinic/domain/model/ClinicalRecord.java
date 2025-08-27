package Clinic.Clinic.domain.model;

public class ClinicalRecord {
    private MedicalNote medicalNote;
    private ClinicalOrder clinicalOrder;
    private VitalSigns vitalSigns;

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
}
