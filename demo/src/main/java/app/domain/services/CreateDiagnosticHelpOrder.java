package app.domain.services;

import app.domain.model.DiagnosticHelpOrder;
import app.domain.model.Patient;
import app.domain.ports.DiagnosticHelpOrderPort;
import app.domain.ports.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDiagnosticHelpOrder {

    @Autowired
    private DiagnosticHelpOrderPort diagnosticHelpOrderPort;
    @Autowired
    private PatientPort patientPort;

    public void createDiagnosticHelpOrder(DiagnosticHelpOrder order) throws Exception {
        if (order.getPatientDocument() == null || order.getPatientDocument().toString().trim().isBlank()) {
            throw new Exception("no se ha recivido el documento de el paciente");
        }

        Patient p = patientPort.findByDocument(order.getPatientDocument());
        if (p == null) {
            throw new Exception("paciente no encontrado. Registra el paciente antes de crear la orden de ayuda diagnostica");
        }

        diagnosticHelpOrderPort.save(order);
    }
}
