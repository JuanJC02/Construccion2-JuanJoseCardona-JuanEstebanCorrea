package app.domain.usecase;

import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.services.CreatePatient;

public class CreatePatientUseCase {

    private CreatePatient createPatient;

    public void execute(Patient patient, User actor) throws Exception {
        createPatient.createPatient(patient, actor);
    }

}
