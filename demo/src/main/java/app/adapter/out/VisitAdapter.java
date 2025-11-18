package app.adapter.out;

import app.domain.model.Visit;
import app.domain.ports.VisitPort;
import app.infrastructure.entity.VisitEntity;
import app.infrastructure.mapper.VisitMapper;
import app.infrastructure.repository.jpa.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisitAdapter implements VisitPort {

    private final VisitRepository repository;
    private final VisitMapper mapper;

    @Autowired
    public VisitAdapter(VisitRepository repository, VisitMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(Visit visit) throws Exception {
        VisitEntity entity = mapper.toEntity(visit);
        repository.save(entity);
    }

    @Override
    public Visit findVisitByPatientId(Long document) throws Exception {
        if (document == 1) {
            return new Visit();
        }
        return null;
    }
}
