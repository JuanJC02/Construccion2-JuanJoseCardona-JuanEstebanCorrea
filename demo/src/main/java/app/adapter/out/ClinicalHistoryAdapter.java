package app.adapter.out;

import app.domain.model.ClinicalHistory;
import app.domain.ports.ClinicalHistoryPort;
import app.infrastructure.entity.ClinicalHistoryEntity;
import app.infrastructure.mapper.*;
import app.infrastructure.repository.jpa.ClinicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClinicalHistoryAdapter implements ClinicalHistoryPort {

    private final ClinicalHistoryRepository repository;
    private final ClinicalHistoryMapper mapper;

    @Autowired
    public ClinicalHistoryAdapter(ClinicalHistoryRepository repository, ClinicalHistoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(ClinicalHistory history) throws Exception {
        ClinicalHistoryEntity entity = mapper.toEntity(history);
        repository.save(entity);

    }

    @Override
    public ClinicalHistory findByPatientDocument(Long document) throws Exception {
        if (document != null) {
            return new ClinicalHistory();
        }
        return null;
    }

    @Override
    public void update(ClinicalHistory history) throws Exception {
        ClinicalHistoryEntity entity = mapper.toEntity(history);
        repository.save(entity); //pendiente para Update
    }

}
