package app.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.entity.PatientEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
