package app.domain.services;

import app.domain.model.DiagnosticHelpOrder;
import app.domain.model.Patient;
import app.domain.ports.DiagnosticHelpOrderPort;
import app.domain.ports.PatientPort;

public class CreateDiagnosticHelpOrder {

    private DiagnosticHelpOrderPort diagnosticHelpOrderPort;
    private PatientPort patientPort;

    public void createDiagnosticHelpOrder(Long patientDocument, DiagnosticHelpOrder order) throws Exception {
        if (patientDocument == null || patientDocument.toString().trim().isBlank()) {
            throw new Exception("no se ha recivido el documento de el paciente");
        }

        Patient p = patientPort.findByDocument(patientDocument);
        if (p == null) {
            throw new Exception("paciente no encontrado. Registra el paciente antes de crear la orden de ayuda diagnostica");
        }

        diagnosticHelpOrderPort.save(order);
    }
}
