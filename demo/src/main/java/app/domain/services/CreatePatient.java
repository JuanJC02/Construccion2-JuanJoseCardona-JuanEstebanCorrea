package app.domain.services;

import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.domain.ports.EmergencyContactPort;
import app.domain.ports.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreatePatient {
    @Autowired
    private PatientPort patientPort;
    @Autowired
    private EmergencyContactPort emergencyContactPort;

    public void createPatient(Patient patient) throws Exception {
        Patient pat2 = patientPort.findByPatient(patient);
        if (pat2.getDocument() != null) {
            throw new Exception("ya existe un paciente registrado con esa cédula");
        }
        if (pat2.getUsername() != null) {
            throw new Exception("ya existe un paciente registrado con ese nombre de usuario");
        }

        EmergencyContact ec = emergencyContactPort.findByDocument(patient.getDocument());
        ec.setName(patient.getName());
        ec.setLastName(patient.getLastName());
        ec.setPhoneNumber(patient.getPhonenumber());
        ec.setPatientDocument(patient.getDocument());
        patientPort.save(patient);
    }

}
