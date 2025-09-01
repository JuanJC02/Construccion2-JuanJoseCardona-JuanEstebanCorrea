package app.domain.services;

import app.domain.Utilities.GenerateRandomAppointmentDate;
import app.domain.model.Appointment;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.AppointmentPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class ScheduleAppointment {

    private UserPort userPort;
    private AppointmentPort appointmentPort;
    private GenerateRandomAppointmentDate randomDate;
    private PatientPort patientPort;

    public void scheduleAppointment(User actor, Appointment appointment) throws Exception {
        User actor1 = userPort.findByActor(actor);
        if (actor1 == null) {
            throw new Exception("actor no encontrado: no se pueden hacer modificaciones");
        }
        if (!actor1.getRole().equals(Role.ADMINISTRATIVE_STAFF)) {
            throw new Exception("el actor no tiene Permisos para modificar los datos");
        }
        if (appointment == null) {
            throw new Exception("no existen citas para programar");
        }
        if (appointment.getPatient().getDocument() == null) {
            throw new Exception("la cita debe contener el documento de el paciente");
        }
        if (appointment.getAppointmentDate() != null) {
            throw new Exception("la cita ya esta programada");
        }

        Patient patient = patientPort.findByDocument(appointment.getPatient());
        if (patient == null) {
            throw new Exception("paciente no encontrado con el documento: " + appointment.getPatient().getDocument());
        }

        LocalDateTime randomDateTime = randomDate.generateRandomAppointmentDate();
        appointment.setAppointmentDate(randomDateTime);
        appointment.setAppointmentId(Math.abs(ThreadLocalRandom.current().nextLong()) * 1000);

        appointment.setPatient(patient);

        appointmentPort.save(appointment);
    }
}
