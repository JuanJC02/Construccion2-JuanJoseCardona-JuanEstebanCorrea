package app.infrastructure.mapper;

import app.domain.model.MedicamentOrder;
import app.infrastructure.entity.MedicamentOrderEntity;
import org.springframework.stereotype.Component;

@Component
public class MedicamentOrderMapper {

    public MedicamentOrder toDomain(MedicamentOrderEntity entity) {
        MedicamentOrder domain = new MedicamentOrder();
        domain.setOrderId(entity.getOrderId());
        domain.setItemNumber(entity.getItemNumber());
        domain.setMedicamentName(entity.getMedicamentName());
        domain.setDose(entity.getDose());
        domain.setTreatmentDuration(entity.getTreatmentDuration());
        domain.setPatientDocument(entity.getPatientDocument());
        return domain;
    }

    public MedicamentOrderEntity toEntity(MedicamentOrder dto) {
        MedicamentOrderEntity entity = new MedicamentOrderEntity();
        entity.setOrderId(dto.getOrderId());
        entity.setItemNumber(dto.getItemNumber());
        entity.setMedicamentName(dto.getMedicamentName());
        entity.setDose(dto.getDose());
        entity.setTreatmentDuration(dto.getTreatmentDuration());
        entity.setPatientDocument(dto.getPatientDocument());
        return entity;
    }
}
