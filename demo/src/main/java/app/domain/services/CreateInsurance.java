package app.domain.services;

import app.domain.model.Insurance;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.InsurancePort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;
import java.time.LocalDate;

public class CreateInsurance {

    private InsurancePort insurancePort;
    private PatientPort patientPort;
    private UserPort userPort;

    public CreateInsurance(InsurancePort insurancePort, PatientPort patientPort) {
        this.insurancePort = insurancePort;
        this.patientPort = patientPort;
    }

    public void registerInsurance(User actor, Insurance insurance) throws Exception {
        User actor1 = userPort.findByActor(actor);
        if (actor1 == null) {
            throw new Exception("actor no encontrado: no se pueden hacer modificaciones");
        }
        if (!actor1.getRole().equals(Role.ADMINISTRATIVE_STAFF)) {
            throw new Exception("el actor no tiene Permisos para modificar los datos");
        }
        
        if (insurance == null) {
            throw new Exception("el seguro no puede ser nulo");
        }

        if (insurance.getCompanyName() == null || insurance.getCompanyName().trim().isEmpty()) {
            throw new Exception("el seguro no tiene el nombre de la compañia");
        }

        if (insurance.getPolicyNumber() == null) {
            throw new Exception("el seguro no tiene un numero de poliza");
        }

        LocalDate exp = insurance.getPolicyExpirationDate();
        if (exp == null) {
            throw new Exception("el seguro no tiene una fecha de expiracion de la poliza");
        }
        if (exp.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("la poliza ha expirado");
        }

        Patient patient = insurance.getPatient();
        if (patient == null) {
            throw new IllegalArgumentException("el seguro debe tener un paciente asociado");
        }

        Patient found;
        try {
            found = patientPort.findByPatient(patient);
        } catch (Exception e) {
            found = null;
        }

        if (found == null) {
            throw new Exception("paciente no encontrado. Registra un nuevo paciente antes de registrar un seguro");
        }

        insurancePort.save(insurance);
    }
}
