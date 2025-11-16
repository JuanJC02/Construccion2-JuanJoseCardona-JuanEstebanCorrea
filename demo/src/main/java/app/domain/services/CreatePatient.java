package app.domain.services;

import app.infrastructure.Utilities.GenerateRandomId;
import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.domain.ports.PatientPort;

public class CreatePatient {

    private PatientPort patientPort;
    private GenerateRandomId generateRandomId;

    public void createPatient(Patient patient) throws Exception {
        Patient pat2 = patientPort.findByPatient(patient);
        if (pat2.getDocument() != null) {
            throw new Exception("ya existe un paciente registrado con esa cédula");
        }
        if (pat2.getUsername() != null) {
            throw new Exception("ya existe un paciente registrado con ese nombre de usuario");
        }
        
        EmergencyContact ec = patient.getEmergencyContact();
        ec.setName(patient.getName());
        ec.setLastName(patient.getLastName());
        ec.setPhoneNumber(patient.getPhonenumber());
        ec.setPatientDocument(patient.getDocument());
        ec.setEmergencyContactID(generateRandomId.generateRandomId());
        patient.setEmergencyContact(ec);
        patientPort.save(patient);
    }








}
