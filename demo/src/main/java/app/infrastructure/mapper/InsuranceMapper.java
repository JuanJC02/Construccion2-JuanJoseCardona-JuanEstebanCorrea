package app.infrastructure.mapper;

import app.domain.model.Insurance;
import app.infrastructure.entity.InsuranceEntity;
import org.springframework.stereotype.Component;

@Component
public class InsuranceMapper {

    public InsuranceEntity toEntity(Insurance insurance) {
        if (insurance == null) {
            return null;
        }

        InsuranceEntity entity = new InsuranceEntity();
        entity.setCompanyName(insurance.getCompanyName());
        entity.setPolicyNumber(insurance.getPolicyNumber());
        entity.setPolicyStatus(insurance.isPolicyStatus());
        entity.setPolicyExpirationDate(insurance.getPolicyExpirationDate());
        entity.setPatientDocument(insurance.getPatientDocument());

        return entity;
    }

    public Insurance toDomain(InsuranceEntity entity) {
        if (entity == null) {
            return null;
        }

        Insurance insurance = new Insurance();
        insurance.setCompanyName(entity.getCompanyName());
        insurance.setPolicyNumber(entity.getPolicyNumber());
        insurance.setPolicyStatus(entity.isPolicyStatus());
        insurance.setPolicyExpirationDate(entity.getPolicyExpirationDate());
        insurance.setPatientDocument(entity.getPatientDocument());

        return insurance;
    }
}
