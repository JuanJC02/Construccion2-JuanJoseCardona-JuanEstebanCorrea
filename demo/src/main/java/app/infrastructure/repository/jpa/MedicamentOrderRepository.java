package app.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.entity.MedicamentOrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentOrderRepository extends JpaRepository<MedicamentOrderEntity, Long> {
}
