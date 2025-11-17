package app.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.entity.InsuranceEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {
}
