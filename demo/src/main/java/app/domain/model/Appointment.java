
package app.domain.model;

import java.sql.Date;

public class Appointment{
    private Date appointmentDate;
    private Patient patient;
    private User attendingPhysician;
    private Long appointmentId;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public User getAttendingPhysician() {
        return attendingPhysician;
    }

    public void setAttendingPhysician(User attendingPhysician) {
        this.attendingPhysician = attendingPhysician;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
}
