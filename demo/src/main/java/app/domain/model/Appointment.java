package app.domain.model;

import java.sql.Date;

public class Appointment {

    private Long appointmentId;
    private Date appointmentDate;
    private Long patientDocument;
    private Long attendingPhysicianDocument;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getAttendingPhysicianDocument() {
        return attendingPhysicianDocument;
    }

    public void setAttendingPhysicianDocument(Long attendingPhysicianDocument) {
        this.attendingPhysicianDocument = attendingPhysicianDocument;
    }

    public Long getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(Long patientDocument) {
        this.patientDocument = patientDocument;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

}
