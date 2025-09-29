package app.domain.services;

//import app.domain.Utilities.GenerateRandomAppointmentDate;
import app.domain.model.Appointment;
import app.domain.model.Patient;
import app.domain.ports.AppointmentPort;
import app.domain.ports.PatientPort;
import java.sql.Date;
//import java.time.LocalDateTime;

public class ScheduleAppointment {

    private AppointmentPort appointmentPort;
    //private GenerateRandomAppointmentDate randomDate;
    private PatientPort patientPort;

    public void scheduleAppointment(Appointment appointment, Date appointmentDate) throws Exception {
        if (appointment == null) {
            throw new Exception("no existen citas para programar");
        }
        if (appointment.getPatientDocument() == null) {
            throw new Exception("la cita debe contener el documento de el paciente");
        }
        if (appointment.getAppointmentDate() != null) {
            throw new Exception("la cita ya esta programada");
        }

        Patient patient = patientPort.findByDocument(appointment.getPatientDocument());
        if (patient == null) {
            throw new Exception("paciente no encontrado con el documento: " + appointment.getPatientDocument());
        }
        
        //LocalDateTime randomDateTime = randomDate.generateRandomAppointmentDate();
        appointment.setAppointmentDate(appointmentDate);
        //appointment.setAppointmentId(Math.abs(ThreadLocalRandom.current().nextLong()) * 1000);

        appointmentPort.save(appointment);
    }
}
