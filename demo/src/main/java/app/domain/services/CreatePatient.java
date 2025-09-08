package app.domain.services;

import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class CreatePatient {

    private UserPort userPort;
    private PatientPort patientPort;

    public void createPatient(Patient patient, User actor) throws Exception {
        User actor1 = userPort.findByActor(actor);
        if (actor1 == null) {
            throw new Exception("actor no encontrado: acceso denegado");
        }
        if (!actor1.getRole().equals(Role.ADMINISTRATIVE_STAFF)) {
            throw new Exception("el actor no tiene permisos para registrar pacientes");
        }

        if (patient.getUsername() == null || !isValidUsername(patient.getUsername())) {
            throw new Exception("nombre de usuario inválido: solo letras y números, máximo 15 caracteres");
        }
        if (patient.getPassword() == null || !isValidPassword(patient.getPassword())) {
            throw new Exception("contraseña inválida: mínimo 8 caracteres, al menos una mayúscula, un número y un carácter especial");
        }
        if (patient.getPhonenumber() != null && !isValidTelefono(patient.getPhonenumber())) {
            throw new Exception("teléfono inválido: deben ser 10 dígitos");
        }
        if (patient.getBirthDate() == null || !isValidFechaNacimiento(patient.getBirthDate())) {
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

    private boolean isValidUsername(String username) {
        return Pattern.matches("^[A-Za-z0-9]{1,15}$", username);
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpper = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[^A-Za-z0-9]").matcher(password).find();
        return hasUpper && hasDigit && hasSpecial;
    }

    private boolean isValidTelefono(String telefono) {
        return Pattern.matches("^\\d{10}$", telefono);
    }

    private boolean isValidFechaNacimiento(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        if (birthDate.isAfter(today)) {
            return false;
        }
        int edad = Period.between(birthDate, today).getYears();
        return edad <= 150;
    }
}
