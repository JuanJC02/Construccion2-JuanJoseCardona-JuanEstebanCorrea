package app.domain.usecase;

import app.domain.model.*;
import app.domain.model.enums.Role;
import static app.domain.model.enums.Role.ADMINISTRATIVE_STAFF;
import app.domain.services.*;
import app.adapters.validators.RoleValidator;
import static app.domain.model.enums.Role.DEVELOP;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class AdministrativeStaffUseCase {

    private CreateBill createBill;
    private ScheduleAppointment scheduleAppointment;
    private CreatePatient createPatient;
    private CreateAppointment createAppointment;
    private RoleValidator roleValidator;

    private final Role rol = ADMINISTRATIVE_STAFF;
    private final Role rol2 = DEVELOP;

    public void registerBill(Long actorDocument, Bill bill) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol2)) {
            createBill.registerBill(bill);
        }
        if (roleValidator.isValidRole(actorDocument, rol)) {
            createBill.registerBill(bill);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void scheduleAppointment(Long actorDocument, Long appointmentId, Date appointmentDate) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol2)) {
            scheduleAppointment.scheduleAppointment(appointmentId, appointmentDate);
        }
        if (roleValidator.isValidRole(actorDocument, rol)) {
            scheduleAppointment.scheduleAppointment(appointmentId, appointmentDate);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createAppointment(Long actorDocument, Appointment appointment) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol2)) {
            createAppointment.createAppointment(appointment);
        }
        if (roleValidator.isValidRole(actorDocument, rol)) {
            createAppointment.createAppointment(appointment);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createPatient(Long actorDocument, Patient patient) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol2)) {
            patient.setRole(Role.PATIENT);
            createPatient.createPatient(patient);
        }
        if (roleValidator.isValidRole(actorDocument, rol)) {
            patient.setRole(Role.PATIENT);
            createPatient.createPatient(patient);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }
}
