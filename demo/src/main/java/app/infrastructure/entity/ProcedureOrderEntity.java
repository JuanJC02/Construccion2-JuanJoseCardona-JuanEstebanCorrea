package app.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "procedure_orders")
public class ProcedureOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;

    @Column(nullable = false)
    private int itemName;

    @Column(nullable = false)
    private String procedureName;

    @Column(nullable = false)
    private int repetitionNumber;

    @Column(nullable = false)
    private int frequency;

    @Column(nullable = false)
    private int cost;

    @Column(nullable = false)
    private boolean requiresSpecialist;

    @Column(nullable = true)
    private Long specialtytId;

    @Column(nullable = false)
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

    public int getItemName() {
        return itemName;
    }

    public void setItemName(int itemName) {
        this.itemName = itemName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public int getRepetitionNumber() {
        return repetitionNumber;
    }

    public void setRepetitionNumber(int repetitionNumber) {
        this.repetitionNumber = repetitionNumber;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
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
