
package app.domain.model;

public class HealthInsurance {
    private String companyName;
    private Long policyNumber;
    private boolean policyStatus;
    private String policyExpiration;

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

    public boolean isPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(boolean policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getPolicyExpiration() {
        return policyExpiration;
    }

    public void setPolicyExpiration(String policyExpiration) {
        this.policyExpiration = policyExpiration;
    }
    
}
