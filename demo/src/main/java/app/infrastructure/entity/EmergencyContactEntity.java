package app.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emergency_contacts")
public class EmergencyContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emergency_contact_id")
    private Long emergencyContactID;

    @Column(name = "patient_document", nullable = false)
    private Long document;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "relation", nullable = false, length = 50)
    private String relation;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    // Getters & Setters
    public Long getEmergencyContactID() {
        return emergencyContactID;
    }

    public void setEmergencyContactID(Long emergencyContactID) {
        this.emergencyContactID = emergencyContactID;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
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
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
