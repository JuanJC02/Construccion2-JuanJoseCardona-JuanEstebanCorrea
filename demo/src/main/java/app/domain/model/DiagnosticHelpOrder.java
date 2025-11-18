package app.domain.model;

public class DiagnosticHelpOrder {

    private Long orderNumber;
    private int itemNumber;
    private String examName;
    private int amount;
    private int cost;
    private boolean requiresSpecialist;
    private Long specialtytId;
    private Long patientDocument;

    public Long getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(Long patientDocument) {
        this.patientDocument = patientDocument;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isRequiresSpecialist() {
        return requiresSpecialist;
    }

    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public Long getSpecialtytId() {
        return specialtytId;
    }

    public void setSpecialtytId(Long specialtytId) {
        this.specialtytId = specialtytId;
    }

}
