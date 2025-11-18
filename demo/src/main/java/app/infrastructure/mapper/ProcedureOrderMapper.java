package app.infrastructure.mapper;

import app.domain.model.ProcedureOrder;
import app.infrastructure.entity.ProcedureOrderEntity;
import org.springframework.stereotype.Component;

@Component
public class ProcedureOrderMapper {

    public ProcedureOrderEntity toEntity(ProcedureOrder model) {
        if (model == null) return null;

        ProcedureOrderEntity entity = new ProcedureOrderEntity();

        entity.setOrderNumber(model.getOrderNumber());
        entity.setItemName(model.getItemName());
        entity.setProcedureName(model.getProcedureName());
        entity.setRepetitionNumber(model.getRepetitionNumber());
        entity.setFrequency(model.getFrequency());
        entity.setCost(model.getCost());
        entity.setRequiresSpecialist(model.isRequiresSpecialist());
        entity.setSpecialtytId(model.getSpecialtytId());
        entity.setPatientDocument(model.getPatientDocument());

        return entity;
    }

    public ProcedureOrder toModel(ProcedureOrderEntity entity) {
        if (entity == null) return null;

        ProcedureOrder model = new ProcedureOrder();

        model.setOrderNumber(entity.getOrderNumber());
        model.setItemName(entity.getItemName());
        model.setProcedureName(entity.getProcedureName());
        model.setRepetitionNumber(entity.getRepetitionNumber());
        model.setFrequency(entity.getFrequency());
        model.setCost(entity.getCost());
        model.setRequiresSpecialist(entity.isRequiresSpecialist());
        model.setSpecialtytId(entity.getSpecialtytId());
        model.setPatientDocument(entity.getPatientDocument());

        return model;
    }
}
