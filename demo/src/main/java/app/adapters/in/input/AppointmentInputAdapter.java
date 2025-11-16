package app.adapters.in.input;

import app.adapters.in.builders.AppointmentBuilder;
import app.domain.model.Appointment;

public class AppointmentInputAdapter {

    private final AppointmentBuilder builder = new AppointmentBuilder();

    public Appointment buildAppointmentFromConsole() {
        return builder.buildFromConsole();
    }
}
