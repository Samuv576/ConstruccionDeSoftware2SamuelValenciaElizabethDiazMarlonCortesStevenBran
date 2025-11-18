package Clinic.Clinic.domain.model;

public class DiagnosticAidOrderItem {
    private Long id;
    private String name;
    private boolean resultAvailable;
    private String itemNumber;
    private String itemDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isResultAvailable() {
        return resultAvailable;
    }

    public void setResultAvailable(boolean resultAvailable) {
        this.resultAvailable = resultAvailable;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }
}
