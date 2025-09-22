package app.domain.usecase;

import app.domain.model.*;
import app.domain.services.*;
import java.util.List;

public class NurseUseCase {

    private RegisterVisit registerVisit;
    private FindPatient findPatient;
    private FindOrders findOrders;

    public void registerVisit(User actor, Visit visit) throws Exception {
        registerVisit.registerVisit(actor, visit);
    }

    public Patient findPatient(Long actorDocument, Long patientDocument) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            return findPatient.findPatient(patientDocument);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }
    
    public List findOrders(User actor, Long patientDocument, String orderType) throws Exception {
        return findOrders.findOrders(actor, patientDocument, orderType);
    }
}
