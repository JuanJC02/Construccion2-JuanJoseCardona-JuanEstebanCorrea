package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class FindPatient {

    private PatientPort patientPort;
    private UserPort userPort;

    public Patient findPatient(User actor, Long patientId) throws Exception {
        User actor1 = userPort.findByActor(actor);
        if (actor1 == null) {
            throw new Exception("actor no encontrado: no se pueden obtener datos");
        }
        if (!actor1.getRole().equals(Role.NURSE) || !actor1.getRole().equals(Role.DOCTOR)) {
            throw new Exception("el actor no tiene Permisos para obtener los datos");
        }
        
        Patient p = patientPort.findByDocument(patientId);
        if (p == null) {
            throw new Exception("paciente con documento: " + patientId + " no encontrado");
        }
        return p;
    }
}
