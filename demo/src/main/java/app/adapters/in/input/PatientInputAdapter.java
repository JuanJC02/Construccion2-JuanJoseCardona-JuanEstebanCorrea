package app.adapters.in.input;

import app.adapters.in.builders.PatientBuilder;
import app.domain.model.Patient;

public class PatientInputAdapter {

    private final PatientBuilder builder = new PatientBuilder();

    public Patient buildPatientFromConsole() {
        return builder.buildFromConsole();
    }
}
