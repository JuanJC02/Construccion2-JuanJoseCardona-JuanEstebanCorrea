
package app.domain.model;

public class Bill {
    private String patientName;
    private int patientAge;
    private Long patientDocument;
    private String treatingPhysicianName;
    private String insuranceCompanyName;
    private Long policyNumber;
    private String policyExpiration;
    private String endDate;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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

    public String getTreatingPhysicianName() {
        return treatingPhysicianName;
    }

    public void setTreatingPhysicianName(String treatingPhysicianName) {
        this.treatingPhysicianName = treatingPhysicianName;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public Long getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Long policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyExpiration() {
        return policyExpiration;
    }

    public void setPolicyExpiration(String policyExpiration) {
        this.policyExpiration = policyExpiration;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
}
