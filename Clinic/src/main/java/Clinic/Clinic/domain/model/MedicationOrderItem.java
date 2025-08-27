package Clinic.Clinic.domain.model;

public class MedicationOrderItem {
    private String id;
    private String dose;
    private int durationDays;
    private String itemNumber;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDose() { return dose; }
    public void setDose(String dose) { this.dose = dose; }

    public int getDurationDays() { return durationDays; }
    public void setDurationDays(int durationDays) { this.durationDays = durationDays; }

    public String getItemNumber() { return itemNumber; }
    public void setItemNumber(String itemNumber) { this.itemNumber = itemNumber; }
}
