package app.domain.usecase;

import app.domain.model.*;
import app.domain.services.*;

public class NurseUseCase {

    private RegisterVisit registerVisit;
    private FindPatient findPatient;

    public void setRegisterVisit(RegisterVisit s) { this.registerVisit = s; }
    public void setFindPatient(FindPatient s) { this.findPatient = s; }

    public void registerVisit(User actor, Visit visit) throws Exception {
        registerVisit.registerVisit(actor, visit);
    }

    public Patient findPatient(User actor, Long patientId) throws Exception {
        return findPatient.findPatient(actor, patientId);
    }
}
