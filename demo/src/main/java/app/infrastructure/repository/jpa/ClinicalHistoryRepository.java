package app.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.entity.ClinicalHistoryEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalHistoryRepository extends JpaRepository<ClinicalHistoryEntity, Long> {

    ClinicalHistoryEntity findFirstByPatientDocument(Long patientDocument);
}
