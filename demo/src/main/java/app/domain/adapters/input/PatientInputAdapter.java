package app.domain.adapters.input;

import app.domain.builders.PatientBuilder;
import app.domain.model.Patient;

public class PatientInputAdapter {

    private final PatientBuilder builder = new PatientBuilder();

    public Patient buildPatientFromConsole() {
        return builder.buildFromConsole();
    }
}
