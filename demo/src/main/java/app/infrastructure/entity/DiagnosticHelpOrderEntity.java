package app.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnostic_help_orders")
public class DiagnosticHelpOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;

    @Column(nullable = false)
    private int itemNumber;

    @Column(nullable = false, length = 200)
    private String examName;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int cost;

    @Column(nullable = false)
    private boolean requiresSpecialist;

    @Column(nullable = false)
    private Long specialtyId;
    
    @Column(nullable = false)
    private Long patientDocument;

    public DiagnosticHelpOrderEntity() {}

    public Long getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(Long PatientDocument) {
        this.patientDocument = PatientDocument;
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

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }
}

