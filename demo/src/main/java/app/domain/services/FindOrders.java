package app.domain.services;

import app.domain.model.MedicamentOrder;
import app.domain.model.ProcedureOrder;
import app.domain.model.DiagnosticHelpOrder;
import app.domain.ports.DiagnosticHelpOrderPort;
import app.domain.ports.MedicamentOrderPort;
import app.domain.ports.ProcedureOrderPort;
import java.util.List;

public class FindOrders {

    private MedicamentOrderPort medicamentOrderPort;
    private ProcedureOrderPort procedureOrderPort;
    private DiagnosticHelpOrderPort diagnosticHelpOrderPort;

    public List findOrders(Long patientDocument, String orderType) throws Exception {
        if(!orderType.equalsIgnoreCase("MEDICAMENT") || !orderType.equalsIgnoreCase("PROCEDURE") || !orderType.equalsIgnoreCase("DIAGNOSTICHELP")) {
            throw new Exception("tipo de orden invalida");
        }

        if (patientDocument == null) {
            throw new Exception("el documento de el paciente es nulo");
        }
        
        List<MedicamentOrder> meds;
        List<ProcedureOrder> procs;
        List<DiagnosticHelpOrder> diags;
        
        if(orderType.equalsIgnoreCase("MEDICAMENT")) {
            meds = medicamentOrderPort.findOrderByPatientDocument(patientDocument);
            return meds;
        }
        if(orderType.equalsIgnoreCase("PROCEDURE")) {
            procs = procedureOrderPort.findOrderByPatientDocument(patientDocument);
            return procs;
        }
        if(orderType.equalsIgnoreCase("DIAGNOSTICHELP")) {
            diags = diagnosticHelpOrderPort.findOrderByPatientDocument(patientDocument);
            return diags;
        }
        return null;
    }
}
