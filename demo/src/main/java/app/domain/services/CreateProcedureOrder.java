package app.domain.services;

import app.domain.model.ProcedureOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.ProcedureOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class CreateProcedureOrder {

    private ProcedureOrderPort procedureOrderPort;
    private PatientPort patientPort;
    private UserPort userPort;

    public void createProcedureOrder(User actor, Long patientDocument, ProcedureOrder order) throws Exception {
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

        Patient p = patientPort.findByDocument(patientDocument);
        if (p == null) {
            throw new Exception("paciente no encontrado. Registra el paciente antes de crear la orden de procedimiento");
        }

        procedureOrderPort.save(order);
    }
}
