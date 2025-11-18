package app.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String patientName;

    @Column(nullable = false, length = 100)
    private String patientLastName;

    private int patientAge;

    @Column(nullable = false)
    private Long patientDocument;

    @Column(nullable = false)
    private Long treatingPhysicianDocument;

    @Column(nullable = false, length = 150)
    private String companyName;

    @Column(nullable = false)
    private Long policyNumber;

    private LocalDate policyExpirationDate;

    public BillEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public Long getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(Long patientDocument) {
        this.patientDocument = patientDocument;
    }

    public Long getTreatingPhysicianDocument() {
        return treatingPhysicianDocument;
    }

    public void setTreatingPhysicianDocument(Long treatingPhysicianDocument) {
        this.treatingPhysicianDocument = treatingPhysicianDocument;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Long policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getPolicyExpirationDate() {
        return policyExpirationDate;
    }

    public void setPolicyExpirationDate(LocalDate policyExpirationDate) {
        this.policyExpirationDate = policyExpirationDate;
    }
}
