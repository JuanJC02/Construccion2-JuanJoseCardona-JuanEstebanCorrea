package app.domain.adapters.input;

import app.domain.builders.AppointmentBuilder;
import app.domain.model.Appointment;

public class AppointmentInputAdapter {

    private final AppointmentBuilder builder = new AppointmentBuilder();

    public Appointment buildAppointmentFromConsole() {
        return builder.buildFromConsole();
    }
}
