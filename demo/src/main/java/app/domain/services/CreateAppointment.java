package app.domain.services;

import app.domain.model.Appointment;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.ports.AppointmentPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAppointment {

    @Autowired
    private UserPort userPort;
    @Autowired
    private AppointmentPort appointmentPort;
    @Autowired
    private PatientPort patientPort;

    public void createAppointment(Appointment appointment) throws Exception {
        if (appointment == null) {
            throw new Exception("no se ha resivido una cita para registrar");
        }
        if (appointment.getPatientDocument() == null || appointment.getPatientDocument().toString().trim().isBlank()) {
            throw new Exception("el documento de el paciente en la cita es nulo");
        }

        Appointment ap = appointment;
        User attendingPhysician = userPort.findByDocument(ap.getAttendingPhysicianDocument());
        Patient patient = patientPort.findByDocument(ap.getPatientDocument());

        if (patient == null) {
            throw new Exception("no se ha encontrado un paciente con ese documento");
        }
        if (attendingPhysician == null) {
            throw new Exception("no se ha encontrado un medico con ese documento");
        }
        appointmentPort.save(ap);
    }

}
