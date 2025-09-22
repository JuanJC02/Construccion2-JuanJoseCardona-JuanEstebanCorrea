package app.domain.usecase;

import app.domain.model.*;
import app.domain.model.enums.Role;
import static app.domain.model.enums.Role.DOCTOR;
import app.domain.services.*;
import app.domain.validators.RoleValidator;

public class DoctorUseCase {

    private ClinicalHistoryService clinicalHistoryService;
    private CreateDiagnosticHelpOrder createDiagnosticHelpOrder;
    private CreateMedicamentOrder createMedicamentOrder;
    private CreateProcedureOrder createProcedureOrder;
    private FindPatient findPatient;
    private RoleValidator roleValidator;
    
    private final Role rol = DOCTOR;

    public void createClinicalHistory(Long actorDocument, Long patientDocument, ClinicalHistory history) throws Exception {
        if(roleValidator.isValidRole(actorDocument, rol)){
            clinicalHistoryService.createClinicalHistory(patientDocument, history);
        }
        else{
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void updateClinicalHistory(Long actorDocument, Long patientDocument, ClinicalHistory history) throws Exception {
        if(roleValidator.isValidRole(actorDocument, rol)){
            clinicalHistoryService.updateClinicalHistory(patientDocument, history);
        }
        else{
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createDiagnosticHelpOrder(Long actorDocument, Long patientDocument, DiagnosticHelpOrder order) throws Exception {
        if(roleValidator.isValidRole(actorDocument, rol)) {
            createDiagnosticHelpOrder.createDiagnosticHelpOrder(patientDocument, order);
        }
        else{
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createMedicamentOrder(Long actorDocument, Long patientDocument, MedicamentOrder order) throws Exception {
        if(roleValidator.isValidRole(actorDocument, rol)) {
        createMedicamentOrder.createMedicamentOrder(patientDocument, order);
        }
        else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createProcedureOrder(Long actorDocument, Long patientDocument, ProcedureOrder order) throws Exception {
        if(roleValidator.isValidRole(actorDocument, rol)) {
            createProcedureOrder.createProcedureOrder(patientDocument, order);
        }
        else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }
    
    
    public Patient findPatient(Long actorDocument,Long patientDocument) throws Exception {
        if(roleValidator.isValidRole(actorDocument, rol)){
            return findPatient.findPatient(patientDocument);
        }
        else{
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }
}
