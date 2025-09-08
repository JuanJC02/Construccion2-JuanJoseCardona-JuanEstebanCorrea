package app.domain.model;

public class Bill {

    private String patientName;
    private int patientAge;
    private Long patientDocument;
    private User treatingPhysicianName;
    private String endDate;
    private Appointment appointment;
    private Insurance insurance;

    public User getTreatingPhysicianName() {
        return treatingPhysicianName;
    }

    public void setTreatingPhysicianName(User treatingPhysicianName) {
        this.treatingPhysicianName = treatingPhysicianName;
    }

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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
