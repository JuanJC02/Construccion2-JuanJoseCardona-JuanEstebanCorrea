package app.domain.usecase;

import app.domain.model.*;
import app.domain.services.*;
import java.sql.Date;

public class DoctorUseCase {

    private ClinicalHistoryService clinicalHistoryService;
    private CreateDiagnosticHelpOrder createDiagnosticHelpOrder;
    private CreateMedicamentOrder createMedicamentOrder;
    private CreateProcedureOrder createProcedureOrder;
    private FindPatient findPatient;

    public void createClinicalHistory(User actor, Long patientDocument, ClinicalHistory history) throws Exception {
        clinicalHistoryService.createClinicalHistory(actor, patientDocument, history);
    }

    public void updateClinicalHistory(User actor, Long patientDocument, ClinicalHistory history) throws Exception {
        clinicalHistoryService.updateClinicalHistory(actor, patientDocument, history);
    }

    public void createDiagnosticHelpOrder(User actor, Long patientDocument, DiagnosticHelpOrder order) throws Exception {
        createDiagnosticHelpOrder.createDiagnosticHelpOrder(actor, patientDocument, order);
    }

    public void createMedicamentOrder(User actor, Long patientDocument, MedicamentOrder order) throws Exception {
        createMedicamentOrder.createMedicamentOrder(actor, patientDocument, order);
    }

    public void createProcedureOrder(User actor, Long patientDocument, ProcedureOrder order) throws Exception {
        createProcedureOrder.createProcedureOrder(actor, patientDocument, order);
    }

    public Patient findPatient(User actor, Long patientId) throws Exception {
        return findPatient.findPatient(actor, patientId);
    }
}
