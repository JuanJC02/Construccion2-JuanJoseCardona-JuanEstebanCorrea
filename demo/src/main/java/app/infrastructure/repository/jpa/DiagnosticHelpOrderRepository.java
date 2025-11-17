
package app.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.entity.DiagnosticHelpOrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticHelpOrderRepository extends JpaRepository<DiagnosticHelpOrderEntity, Long> {
}
