package app.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.entity.ProcedureOrderEntity;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureOrderRepository extends JpaRepository<ProcedureOrderEntity, Long> {
    List<ProcedureOrderEntity> findByPatientDocument(Long patientDocument);
}
