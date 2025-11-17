
package app.adapter.out;

import app.domain.ports.AppointmentPort;
import app.infrastructure.entity.AppointmentEntity;
import app.infrastructure.repository.jpa.AppointmentRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class AppointmentPersistenceAdapter implements AppointmentPort {

    private final AppointmentRepository repository;

    public AppointmentPersistenceAdapter(AppointmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public AppointmentEntity save(AppointmentEntity entity) {
        return repository.save(entity);
    }
}
