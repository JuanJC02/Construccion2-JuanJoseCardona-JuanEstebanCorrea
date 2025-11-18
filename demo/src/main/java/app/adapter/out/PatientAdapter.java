package app.adapter.out;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;
import app.infrastructure.entity.PatientEntity;
import app.infrastructure.mapper.PatientMapper;
import app.infrastructure.repository.jpa.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientAdapter implements PatientPort {

    private final PatientRepository repository;
    private final PatientMapper mapper;

    @Autowired
    public PatientAdapter(PatientRepository repository, PatientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Patient findByPatient(Patient patient) throws Exception {
        if (patient != null) { //cambiar. buscar por repositorio
            return new Patient();
        }
        return null;
    }

    @Override
    public Patient findByDocument(Long document) throws Exception {
        if (document != null) { //cambiar. buscar por repositorio
            return new Patient();
        }
        return null;
    }

    @Override
    public void save(Patient patient) throws Exception {
        PatientEntity entity = mapper.toEntity(patient);
        repository.save(entity);
    }

}
