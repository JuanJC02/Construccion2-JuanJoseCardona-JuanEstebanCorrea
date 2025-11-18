package app.infrastructure.mapper;

import app.domain.model.Appointment;
import app.infrastructure.entity.AppointmentEntity;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentEntity toEntity(Appointment appointment) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setAppointmentId(appointment.getAppointmentId());
        entity.setAppointmentDate(appointment.getAppointmentDate());
        entity.setPatientDocument(appointment.getPatientDocument());
        entity.setAttendingPhysicianDocument(appointment.getAttendingPhysicianDocument());
        return entity;
    }

    public Appointment toDomain(AppointmentEntity entity) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(entity.getAppointmentId());
        appointment.setAppointmentDate(entity.getAppointmentDate());
        appointment.setPatientDocument(entity.getPatientDocument());
        appointment.setAttendingPhysicianDocument(entity.getAttendingPhysicianDocument());
        return appointment;
    }
}
