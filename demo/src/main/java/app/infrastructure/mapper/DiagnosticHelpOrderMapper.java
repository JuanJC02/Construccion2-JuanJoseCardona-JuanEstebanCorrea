package app.infrastructure.mapper;

import app.domain.model.DiagnosticHelpOrder;
import app.infrastructure.entity.DiagnosticHelpOrderEntity;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticHelpOrderMapper {

    public DiagnosticHelpOrderEntity toEntity(DiagnosticHelpOrder domain) {
        DiagnosticHelpOrderEntity entity = new DiagnosticHelpOrderEntity();
        entity.setPatientDocument(domain.getPatientDocument());
        entity.setOrderNumber(domain.getOrderNumber());
        entity.setItemNumber(domain.getItemNumber());
        entity.setExamName(domain.getExamName());
        entity.setAmount(domain.getAmount());
        entity.setCost(domain.getCost());
        entity.setRequiresSpecialist(domain.isRequiresSpecialist());
        entity.setSpecialtyId(domain.getSpecialtytId());
        return entity;
    }

    public DiagnosticHelpOrder toDomain(DiagnosticHelpOrderEntity entity) {
        DiagnosticHelpOrder domain = new DiagnosticHelpOrder();
        domain.setPatientDocument(entity.getPatientDocument());
        domain.setOrderNumber(entity.getOrderNumber());
        domain.setItemNumber(entity.getItemNumber());
        domain.setExamName(entity.getExamName());
        domain.setAmount(entity.getAmount());
        domain.setCost(entity.getCost());
        domain.setRequiresSpecialist(entity.isRequiresSpecialist());
        domain.setSpecialtytId(entity.getSpecialtyId());
        return domain;
    }
}
