package app.domain.services;

import app.domain.model.MedicamentOrder;
import app.domain.model.ProcedureOrder;
import app.domain.model.DiagnosticHelpOrder;
import app.domain.ports.DiagnosticHelpOrderPort;
import app.domain.ports.MedicamentOrderPort;
import app.domain.ports.ProcedureOrderPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindOrders {

    private final MedicamentOrderPort medicamentOrderPort;
    private final ProcedureOrderPort procedureOrderPort;
    private final DiagnosticHelpOrderPort diagnosticHelpOrderPort;

    @Autowired
    public FindOrders(MedicamentOrderPort medicamentOrderPort,
                      ProcedureOrderPort procedureOrderPort,
                      DiagnosticHelpOrderPort diagnosticHelpOrderPort) {
        this.medicamentOrderPort = medicamentOrderPort;
        this.procedureOrderPort = procedureOrderPort;
        this.diagnosticHelpOrderPort = diagnosticHelpOrderPort;
    }

    public List<?> findOrders(Long patientDocument, String orderType) throws Exception {

        if (patientDocument == null) {
            throw new Exception("El documento del paciente es nulo");
        }

        if (orderType == null || orderType.isBlank()) {
            throw new Exception("El tipo de orden no puede estar vacío");
        }

        switch (orderType.toUpperCase()) {

            case "MEDICAMENT":
                return medicamentOrderPort.findOrderByPatientDocument(patientDocument);

            case "PROCEDURE":
                return procedureOrderPort.findOrderByPatientDocument(patientDocument);

            case "DIAGNOSTICHELP":
                return diagnosticHelpOrderPort.findOrderByPatientDocument(patientDocument);

            default:
                throw new Exception("Tipo de orden inválido: debe ser MEDICAMENT, PROCEDURE o DIAGNOSTICHELP");
        }
    }
}
