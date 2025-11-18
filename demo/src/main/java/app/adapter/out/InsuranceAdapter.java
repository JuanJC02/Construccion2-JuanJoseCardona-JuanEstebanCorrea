package app.adapter.out;

import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;
import app.infrastructure.entity.InsuranceEntity;
import app.infrastructure.mapper.InsuranceMapper;
import app.infrastructure.repository.jpa.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsuranceAdapter implements InsurancePort {

    private final InsuranceRepository insuranceRepository;
    private final InsuranceMapper insuranceMapper;
    
    @Autowired
    public InsuranceAdapter(InsuranceRepository insuranceRepository, InsuranceMapper insuranceMapper) {
        this.insuranceRepository = insuranceRepository;
        this.insuranceMapper = insuranceMapper;
    }

    @Override
    public void save(Insurance insurance) throws Exception {
        if (insurance == null) {
            throw new Exception("No se puede guardar una póliza nula");
        }

        InsuranceEntity entity = insuranceMapper.toEntity(insurance);
        insuranceRepository.save(entity);
    }

    @Override
    public Insurance findById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("El ID no puede ser nulo");
        }

        InsuranceEntity entity = insuranceRepository.findById(id)
                .orElse(null);

        if (entity == null) {
            return null;
        }

        return insuranceMapper.toDomain(entity);
    }
}