package app.domain.usecase;

import app.domain.model.*;
import app.domain.services.*;
import java.sql.Date;

public class AdministrativeStaffUseCase {

    private CreateBill createBill;
    private ScheduleAppointment scheduleAppointment;
    private CreatePatient createPatient;

    public void registerBill(User actor, Bill bill) throws Exception {
        createBill.registerBill(actor, bill);
    }

    public void scheduleAppointment(User actor, Appointment appointment, Date appointmentDate) throws Exception {
        scheduleAppointment.scheduleAppointment(actor, appointment, appointmentDate);
    }

    public void createPatient(Patient patient, User actor) throws Exception {
        createPatient.createPatient(patient, actor);
    }
}
