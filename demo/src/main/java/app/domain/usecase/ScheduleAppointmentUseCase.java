
package app.domain.usecase;

import app.domain.model.Appointment;
import app.domain.model.User;
import app.domain.services.ScheduleAppointment;

public class ScheduleAppointmentUseCase {
    private ScheduleAppointment scheduleAppointment;
    
    public void execute(User actor, Appointment appointment) throws Exception {
        scheduleAppointment.scheduleAppointment(actor, appointment);
    }
}
