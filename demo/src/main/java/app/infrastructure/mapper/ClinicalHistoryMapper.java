package app.infrastructure.mapper;

import app.domain.model.ClinicalHistory;
import app.infrastructure.entity.ClinicalHistoryEntity;
import org.springframework.stereotype.Component;

@Component
public class ClinicalHistoryMapper {

    public ClinicalHistoryEntity toEntity(ClinicalHistory domain) {
        if (domain == null) {
            return null;
        }

        ClinicalHistoryEntity entity = new ClinicalHistoryEntity();

        entity.setDate(domain.getDate());
        entity.setDoctorId(domain.getDoctorId());
        entity.setReasonForConsultation(domain.getReasonForConsultation());
        entity.setSymptoms(domain.getSymptoms());
        entity.setDiagnosis(domain.getDiagnosis());
        entity.setPatientDocument(domain.getPatientDocument());

        return entity;
    }

    public ClinicalHistory toDomain(ClinicalHistoryEntity entity) {
        if (entity == null) {
            return null;
        }

        ClinicalHistory domain = new ClinicalHistory();

        domain.setDate(entity.getDate());
        domain.setDoctorId(entity.getDoctorId());
        domain.setReasonForConsultation(entity.getReasonForConsultation());
        domain.setSymptoms(entity.getSymptoms());
        domain.setDiagnosis(entity.getDiagnosis());
        domain.setPatientDocument(entity.getPatientDocument());

        return domain;
    }
}
