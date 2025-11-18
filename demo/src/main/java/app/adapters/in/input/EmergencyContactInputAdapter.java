package app.adapters.in.input;

import app.adapters.in.builders.EmergencyContactBuilder;
import app.domain.model.EmergencyContact;

public class EmergencyContactInputAdapter {

    private final EmergencyContactBuilder builder = new EmergencyContactBuilder();

    public EmergencyContact buildEmergencyContactFromConsole() {
        return builder.buildFromConsole();
    }
}
