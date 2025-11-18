package app.infrastructure.mapper;

import app.domain.model.Visit;
import app.infrastructure.entity.VisitEntity;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper {

    public VisitEntity toEntity(Visit visit) {
        if (visit == null) {
            return null;
        }

        VisitEntity entity = new VisitEntity();
        entity.setPatientToVisitDocument(visit.getPatientToVisitDocument());
        entity.setVisitDate(visit.getVisitDate());
        entity.setBloodPressure(visit.getBloodPressure());
        entity.setTemperature(visit.getTemperature());
        entity.setHeartRate(visit.getHeartRate());
        entity.setBloodOxigenLevel(visit.getBloodOxigenLevel());

        return entity;
    }

    public Visit toModel(VisitEntity entity) {
        if (entity == null) {
            return null;
        }

        Visit visit = new Visit();
        visit.setPatientToVisitDocument(entity.getPatientToVisitDocument());
        visit.setVisitDate(entity.getVisitDate());
        visit.setBloodPressure(entity.getBloodPressure());
        visit.setTemperature(entity.getTemperature());
        visit.setHeartRate(entity.getHeartRate());
        visit.setBloodOxigenLevel(entity.getBloodOxigenLevel());

        return visit;
    }
}
