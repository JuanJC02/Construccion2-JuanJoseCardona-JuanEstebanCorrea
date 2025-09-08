package app.domain.services;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.model.MedicamentOrder;
import app.domain.model.ProcedureOrder;
import app.domain.model.DiagnosticHelpOrder;
import app.domain.ports.DiagnosticHelpOrderPort;
import app.domain.ports.MedicamentOrderPort;
import app.domain.ports.ProcedureOrderPort;
import app.domain.ports.UserPort;
import java.util.List;

public class NurseOrderSearchService {

    private UserPort userPort;
    private MedicamentOrderPort medicamentOrderPort;
    private ProcedureOrderPort procedureOrderPort;
    private DiagnosticHelpOrderPort diagnosticHelpOrderPort;

    public List findOrdersByPatient(User actor, Long patientDocument, String orderType) throws Exception {
        if(!orderType.equalsIgnoreCase("MEDICAMENT") || !orderType.equalsIgnoreCase("PROCEDURE") || !orderType.equalsIgnoreCase("DIAGNOSTICHELP")) {
            throw new Exception("tipo de ordern invalida");
        }
        
        User actor1 = userPort.findByActor(actor);
        if (actor1 == null) {
            throw new Exception("actor no encontrado: no se pueden obtener los datos");
        }
        if (!actor1.getRole().equals(Role.NURSE)) {
            throw new Exception("el actor no tiene Permisos para obtener los datos");
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
