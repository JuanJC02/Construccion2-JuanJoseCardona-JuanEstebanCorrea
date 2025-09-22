package app.domain.services;

import app.domain.model.ProcedureOrder;
import app.domain.model.Patient;
import app.domain.ports.ProcedureOrderPort;
import app.domain.ports.PatientPort;

public class CreateProcedureOrder {

    private ProcedureOrderPort procedureOrderPort;
    private PatientPort patientPort;

    public void createProcedureOrder(Long patientDocument, ProcedureOrder order) throws Exception {
        if (patientDocument == null || patientDocument.toString().trim().isBlank()) {
            throw new Exception("no se ha resivido el documento de el paciente");
        }

        Patient p = patientPort.findByDocument(patientDocument);
        if (p == null) {
            throw new Exception("paciente no encontrado. Registra el paciente antes de crear la orden de procedimiento");
        }
        
        if(order.getPatientDocument() == null || order.getPatientDocument().toString().trim().isBlank()){
            order.setPatientDocument(patientDocument);
        }

        procedureOrderPort.save(order);
    }
}
