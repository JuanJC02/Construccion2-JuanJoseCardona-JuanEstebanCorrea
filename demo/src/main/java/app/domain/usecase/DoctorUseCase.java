package app.domain.usecase;

import app.domain.model.*;
import app.domain.model.enums.Role;
import static app.domain.model.enums.Role.DOCTOR;

import org.springframework.stereotype.Component;

import app.domain.services.*;
import app.adapters.validators.RoleValidator;
import static app.domain.model.enums.Role.DEVELOP;
@Component
public class DoctorUseCase {

    private ClinicalHistoryService clinicalHistoryService;
    private CreateDiagnosticHelpOrder createDiagnosticHelpOrder;
    private CreateMedicamentOrder createMedicamentOrder;
    private CreateProcedureOrder createProcedureOrder;
    private FindPatient findPatient;
    private RoleValidator roleValidator;

    private final Role rol = DOCTOR;
    private final Role rol2 = DEVELOP;

    public void createClinicalHistory(Long actorDocument, ClinicalHistory history) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol2)) {
            clinicalHistoryService.createClinicalHistory(history);
        }
        if (roleValidator.isValidRole(actorDocument, rol)) {
            clinicalHistoryService.createClinicalHistory(history);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void updateClinicalHistory(Long actorDocument, ClinicalHistory history) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol2)) {
            clinicalHistoryService.updateClinicalHistory(history);
        }
        if (roleValidator.isValidRole(actorDocument, rol)) {
            clinicalHistoryService.updateClinicalHistory(history);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createDiagnosticHelpOrder(Long actorDocument, DiagnosticHelpOrder order) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol2)) {
            createDiagnosticHelpOrder.createDiagnosticHelpOrder(order);
        }
        if (roleValidator.isValidRole(actorDocument, rol)) {
            createDiagnosticHelpOrder.createDiagnosticHelpOrder(order);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createMedicamentOrder(Long actorDocument, MedicamentOrder order) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol2)) {
            createMedicamentOrder.createMedicamentOrder(order);
        }
        if (roleValidator.isValidRole(actorDocument, rol)) {
            createMedicamentOrder.createMedicamentOrder(order);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createProcedureOrder(Long actorDocument, ProcedureOrder order) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol2)) {
            createProcedureOrder.createProcedureOrder(order);
        }
        if (roleValidator.isValidRole(actorDocument, rol)) {
            createProcedureOrder.createProcedureOrder(order);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public Patient findPatient(Long actorDocument, Long patientDocument) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol2)) {
            return findPatient.findPatient(patientDocument);
        }
        if (roleValidator.isValidRole(actorDocument, rol)) {
            return findPatient.findPatient(patientDocument);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }
}
