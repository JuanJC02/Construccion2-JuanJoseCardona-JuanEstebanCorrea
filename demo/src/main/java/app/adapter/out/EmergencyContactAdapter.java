package app.adapter.out;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;
import app.infrastructure.entity.EmergencyContactEntity;
import app.infrastructure.mapper.EmergencyContactMapper;
import app.infrastructure.repository.jpa.EmergencyContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmergencyContactAdapter implements EmergencyContactPort {

    private final EmergencyContactRepository repository;
    private final EmergencyContactMapper mapper;

    @Autowired
    public EmergencyContactAdapter(EmergencyContactRepository repository, EmergencyContactMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(EmergencyContact emergencyContact) throws Exception {
        if (emergencyContact == null) {
            throw new Exception("El contacto de emergencia no puede ser nulo");
        }
        EmergencyContactEntity entity = mapper.toEntity(emergencyContact);
        repository.save(entity);
    }

    @Override
    public EmergencyContact findByDocument(Long Document) throws Exception {
        return mapper.toModel(repository.findByDocument(Document));
    }
}
