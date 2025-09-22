package app.domain.services;

import app.domain.Utilities.GenerateRandomId;
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

    public void createAppointment(Appointment appointment, Long patientDocument, Long attendingPhysicianDocument) throws Exception {
        if (appointment == null) {
            throw new Exception("no se ha resivido una cita para registrar");
        }
        if (patientDocument == null & appointment.getPatient() == null || patientDocument.toString().trim().isBlank() & appointment.getPatient() == null) {
            throw new Exception("no se ha resivido el documento de el paciente. No se puede crear la cita");
        }
        if (attendingPhysicianDocument == null & appointment.getAttendingPhysician() == null || attendingPhysicianDocument.toString().trim().isBlank() & appointment.getAttendingPhysician() == null) {
            throw new Exception("no se ha resivido el documento de el medico tratante. No se puede crear la cita");
        }
        
        Appointment ap = appointment;
        if (ap.getAppointmentId().equals(appointmentPort.findAppointmentIdById(ap.getAppointmentId()))) {
            throw new Exception("ya existe una cita registrada con ese ID");
        }
        
        User attendingPhysician = userPort.findByDocument(attendingPhysicianDocument);
        Patient patient = patientPort.findByDocument(patientDocument);

        if (patient == null) {
            throw new Exception("no se ha encontrado un paciente con ese documento");
        }
        if(attendingPhysician == null){
            throw new Exception("no se ha encontrado un medico con ese documento");
        }
        if (ap.getAppointmentId() == null || ap.getAppointmentId().toString().trim().isBlank()) {
            ap.setAppointmentId(generateRandomId.generateRandomId());
        }
        ap.setAttendingPhysician(attendingPhysician);
        ap.setPatient(patient);

        appointmentPort.save(ap);
    }
}
