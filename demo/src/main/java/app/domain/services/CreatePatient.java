package app.domain.services;

import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;
import app.domain.validators.SimpleValidators;

public class CreatePatient {

    private PatientPort patientPort;
    private SimpleValidators simpleValidators;

    public void createPatient(Patient patient) throws Exception {
        if (patient.getUsername() == null || !simpleValidators.isValidUsername(patient.getUsername())) {
            throw new Exception("nombre de usuario inválido: solo letras y números, máximo 15 caracteres");
        }
        if (patient.getPassword() == null || !simpleValidators.isValidPassword(patient.getPassword())) {
            throw new Exception("contraseña inválida: mínimo 8 caracteres, al menos una mayúscula, un número y un carácter especial");
        }
        if (patient.getPhonenumber() != null && !simpleValidators.isValidTelefono(patient.getPhonenumber())) {
            throw new Exception("teléfono inválido: deben ser 10 dígitos");
        }
        if (patient.getBirthDate() == null || !simpleValidators.isValidFechaNacimiento(patient.getBirthDate())) {
            throw new Exception("fecha de nacimiento inválida: formato y edad máxima 150 años");
        }
        
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
        patient.setEmergencyContact(ec);
        patientPort.save(patient);
    }








}
