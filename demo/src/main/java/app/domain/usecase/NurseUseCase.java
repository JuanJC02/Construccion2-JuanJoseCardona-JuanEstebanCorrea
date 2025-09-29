package app.domain.usecase;

import app.domain.model.*;
import app.domain.model.enums.Role;
import static app.domain.model.enums.Role.NURSE;
import app.domain.services.*;
import app.domain.validators.RoleValidator;
import java.util.List;

public class NurseUseCase {

    private RegisterVisit registerVisit;
    private FindPatient findPatient;
    private FindOrders findOrders;
    private RoleValidator roleValidator;

    private final Role rol = NURSE;

    public void registerVisit(Long actorDocument, Visit visit) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            registerVisit.registerVisit(visit);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }

    }

    public Patient findPatient(Long actorDocument, Long patientDocument) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            return findPatient.findPatient(patientDocument);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public List findOrders(Long actorDocument, Long patientDocument, String orderType) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            return findOrders.findOrders(patientDocument, orderType);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }

    }
}
