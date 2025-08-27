package Clinic.Clinic.domain.model;

public class DiagnosticAidOrderItem {
    private String id;
    private String name;
    private boolean resultAvailable;
    private String itemNumber;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isResultAvailable() { return resultAvailable; }
    public void setResultAvailable(boolean resultAvailable) { this.resultAvailable = resultAvailable; }

    public String getItemNumber() { return itemNumber; }
    public void setItemNumber(String itemNumber) { this.itemNumber = itemNumber; }
}
