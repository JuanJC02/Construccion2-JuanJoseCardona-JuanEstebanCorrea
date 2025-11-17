package app.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.entity.VisitEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {
}
