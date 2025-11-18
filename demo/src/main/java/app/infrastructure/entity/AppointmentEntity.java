package app.infrastructure.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "appointments")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private Date appointmentDate;
    private Long patientDocument;
    private Long attendingPhysicianDocument;

    public AppointmentEntity() {
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Long getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(Long patientDocument) {
        this.patientDocument = patientDocument;
    }

    public Long getAttendingPhysicianDocument() {
        return attendingPhysicianDocument;
    }

    public void setAttendingPhysicianDocument(Long attendingPhysicianDocument) {
        this.attendingPhysicianDocument = attendingPhysicianDocument;
    }
}
