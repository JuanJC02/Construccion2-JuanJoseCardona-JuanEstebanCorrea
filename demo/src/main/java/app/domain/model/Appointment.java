
package app.domain.model;

import java.time.LocalDateTime;

public class Appointment{
    private LocalDateTime appointmentDate;
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

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
}
