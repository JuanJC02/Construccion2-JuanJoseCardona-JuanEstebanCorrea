package app.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.entity.ProcedureOrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureOrderRepository extends JpaRepository<ProcedureOrderEntity, Long> {
}
