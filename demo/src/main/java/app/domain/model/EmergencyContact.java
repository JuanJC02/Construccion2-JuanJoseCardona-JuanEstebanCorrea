package app.domain.model;

public class EmergencyContact {

    private String name;
    private String lastName;
    private String Relation;
    private String phoneNumber;
    private Long emergencyContactID;
    private Long patientDocument;

    public Long getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(Long patientDocument) {
        this.patientDocument = patientDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRelation() {
        return Relation;
    }

    public void setRelation(String Relation) {
        this.Relation = Relation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getEmergencyContactID() {
        return emergencyContactID;
    }

    public void setEmergencyContactID(Long emergencyContactID) {
        this.emergencyContactID = emergencyContactID;
    }

}
