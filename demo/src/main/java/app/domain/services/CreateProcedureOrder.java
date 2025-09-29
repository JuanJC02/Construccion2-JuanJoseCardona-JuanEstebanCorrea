package app.domain.services;

import app.domain.model.ProcedureOrder;
import app.domain.ports.ProcedureOrderPort;
import app.domain.ports.PatientPort;

public class CreateProcedureOrder {

    private ProcedureOrderPort procedureOrderPort;
    private PatientPort patientPort;

    public void createProcedureOrder(ProcedureOrder order, Long specialtytId) throws Exception {
        if (order.getPatientDocument() == null || order.getPatientDocument().toString().trim().isBlank()) {
            throw new Exception("no se ha resivido el documento de el paciente");
        }
        if (patientPort.findByDocument(order.getPatientDocument()) == null) {
            throw new Exception("paciente no encontrado. Registra el paciente antes de crear la orden de procedimiento");
        }

        if (specialtytId == null || specialtytId.toString().trim().isBlank()) {
            throw new Exception("la id de la especialidad es nula");
        }

        if (order.getSpecialtytId() == null || order.getSpecialtytId().toString().trim().isBlank()) {
            throw new Exception("la id de la especialidad de la orden es nula");
        }

        procedureOrderPort.save(order);
    }
}
