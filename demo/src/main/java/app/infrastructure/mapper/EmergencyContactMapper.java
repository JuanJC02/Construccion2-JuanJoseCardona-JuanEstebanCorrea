package app.infrastructure.mapper;

import app.domain.model.EmergencyContact;
import app.infrastructure.entity.EmergencyContactEntity;
import org.springframework.stereotype.Component;

@Component
public class EmergencyContactMapper {

    public EmergencyContactEntity toEntity(EmergencyContact model) {
        if (model == null) return null;

        EmergencyContactEntity entity = new EmergencyContactEntity();

        entity.setEmergencyContactID(model.getEmergencyContactID());
        entity.setName(model.getName());
        entity.setLastName(model.getLastName());
        entity.setRelation(model.getRelation());
        entity.setPhoneNumber(model.getPhoneNumber());
        entity.setDocument(model.getPatientDocument());

        return entity;
    }

    public EmergencyContact toModel(EmergencyContactEntity entity) {
        if (entity == null) return null;

        EmergencyContact model = new EmergencyContact();

        model.setEmergencyContactID(entity.getEmergencyContactID());
        model.setName(entity.getName());
        model.setLastName(entity.getLastName());
        model.setRelation(entity.getRelation());
        model.setPhoneNumber(entity.getPhoneNumber());
        model.setPatientDocument(entity.getDocument());

        return model;
    }
}
