package app.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.entity.MedicamentOrderEntity;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentOrderRepository extends JpaRepository<MedicamentOrderEntity, Long> {

    List<MedicamentOrderEntity> findByPatientDocument(Long patientDocument);
}
