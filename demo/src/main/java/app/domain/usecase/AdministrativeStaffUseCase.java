package app.domain.usecase;

import app.domain.model.*;
import app.domain.model.enums.Role;
import static app.domain.model.enums.Role.ADMINISTRATIVE_STAFF;
import app.domain.services.*;
import app.domain.validators.RoleValidator;
import java.sql.Date;

public class AdministrativeStaffUseCase {

    private CreateBill createBill;
    private ScheduleAppointment scheduleAppointment;
    private CreatePatient createPatient;
    private CreateAppointment createAppointment;
    private RoleValidator roleValidator;

    private final Role rol = ADMINISTRATIVE_STAFF;

    public void registerBill(Long actorDocument, Bill bill) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            createBill.registerBill(bill);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void scheduleAppointment(Long actorDocument, Appointment appointment, Date appointmentDate) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            scheduleAppointment.scheduleAppointment(appointment, appointmentDate);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createAppointment(Long actorDocument, Appointment appointment, Long patientDocument, Long attendingPhysicianDocument) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            createAppointment.createAppointment(appointment, patientDocument, attendingPhysicianDocument);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createPatient(Long actorDocument, Patient patient) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            patient.setRole(Role.PATIENT);
            createPatient.createPatient(patient);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }
}
