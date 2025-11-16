package app.domain.services;

import app.infrastructure.Utilities.GenerateRandomId;
import app.domain.model.Appointment;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.ports.AppointmentPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class CreateAppointment {

    private UserPort userPort;
    private AppointmentPort appointmentPort;
    private PatientPort patientPort;
    private GenerateRandomId generateRandomId;

    public void createAppointment(Appointment appointment, Long attendingPhysicianDocument) throws Exception {
        if (appointment == null) {
            throw new Exception("no se ha resivido una cita para registrar");
        }
        if(appointment.getPatientDocument() == null || appointment.getPatientDocument().toString().trim().isBlank()) {
            throw new Exception("el documento de el paciente en la cita es nulo");
        }
        
        /*
        if (appointment.getAttendingPhysicianDocument() == null || appointment.getAttendingPhysicianDocument().toString().trim().isBlank()) {
            throw new Exception("el documento de el medico trantante en la cita recibida es nulo");
        }
        */
        
        Appointment ap = appointment;
        if (ap.getAppointmentId().equals(appointmentPort.findAppointmentIdById(ap.getAppointmentId()))) {
            throw new Exception("ya existe una cita registrada con ese ID");
        }
        
        User attendingPhysician = userPort.findByDocument(attendingPhysicianDocument);
        Patient patient = patientPort.findByDocument(ap.getPatientDocument());

        if (patient == null) {
            throw new Exception("no se ha encontrado un paciente con ese documento");
        }
        if(attendingPhysician == null){
            throw new Exception("no se ha encontrado un medico con ese documento");
        }
        if (ap.getAppointmentId() == null || ap.getAppointmentId().toString().trim().isBlank()) {
            ap.setAppointmentId(generateRandomId.generateRandomId());
        }

        appointmentPort.save(ap);
    }
}
