package app.domain.services;

import app.domain.model.Appointment;
import app.domain.model.Patient;
import app.domain.ports.AppointmentPort;
import app.domain.ports.PatientPort;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleAppointment {

    private final AppointmentPort appointmentPort;
    private final PatientPort patientPort;
    
    @Autowired
    public ScheduleAppointment(AppointmentPort appointmentPort, PatientPort patientPort) {
        this.appointmentPort = appointmentPort;
        this.patientPort = patientPort;
    }

    public void scheduleAppointment(Long appointmentId, Date appointmentDate) throws Exception {

        if (appointmentId == null) {
            throw new Exception("Debe proporcionar el ID de la cita a programar.");
        }

        if (appointmentDate == null) {
            throw new Exception("Debe proporcionar la fecha para programar la cita.");
        }

        Appointment appointment = appointmentPort.findAppointmentById(appointmentId);
        if (appointment == null) {
            throw new Exception("No existe una cita con el ID proporcionado.");
        }

        if (appointment.getAppointmentDate() != null) {
            throw new Exception("La cita ya se encuentra programada.");
        }

        if (appointment.getPatientDocument() == null) {
            throw new Exception("La cita no contiene documento de paciente.");
        }

        Patient patient = patientPort.findByDocument(appointment.getPatientDocument());
        if (patient == null) {
            throw new Exception("No se encontró un paciente con documento: " + appointment.getPatientDocument());
        }

        appointment.setAppointmentDate(appointmentDate);

        appointmentPort.save(appointment);
    }
}