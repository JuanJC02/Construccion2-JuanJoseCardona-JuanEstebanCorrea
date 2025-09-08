package app.domain.services;

import app.domain.model.DiagnosticHelpOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.DiagnosticHelpOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class CreateDiagnosticHelpOrder {

    private DiagnosticHelpOrderPort diagnosticHelpOrderPort;
    private PatientPort patientPort;
    private UserPort userPort;

    public void createDiagnosticHelpOrder(User actor, Long patientDocument, DiagnosticHelpOrder order) throws Exception {
        User actor1 = userPort.findByActor(actor);
        if (actor1 == null) {
            throw new Exception("actor no encontrado: no se pueden hacer modificaciones");
        }
        if (!actor1.getRole().equals(Role.DOCTOR)) {
            throw new Exception("el actor no tiene Permisos para modificar los datos");
        }
        if (patientDocument == null) {
            throw new Exception("documento de paciente es nulo");
        }

        Patient found = patientPort.findByDocument(patientDocument);
        if (found == null) {
            throw new Exception("paciente no encontrado. Registra el paciente antes de crear la orden de ayuda diagnostica");
        }

        diagnosticHelpOrderPort.save(order);
    }
}
