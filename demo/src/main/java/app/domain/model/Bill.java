package app.domain.model;

import java.time.LocalDate;

public class Bill {

    private String patientName;
    private String patientLastName;
    private int patientAge;
    private Long patientDocument;
    private Long treatingPhysicianDocument;
    private String companyName;
    private Long policyNumber;
    private LocalDate policyExpirationDate;

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
