package app.adapter.out;

import app.domain.model.MedicamentOrder;
import app.domain.ports.MedicamentOrderPort;
import app.infrastructure.entity.MedicamentOrderEntity;
import app.infrastructure.mapper.MedicamentOrderMapper;
import app.infrastructure.repository.jpa.MedicamentOrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class MedicamentOrderAdapter implements MedicamentOrderPort {

    private final MedicamentOrderRepository repository;
    private final MedicamentOrderMapper mapper;

    @Autowired
    public MedicamentOrderAdapter(MedicamentOrderRepository repository, MedicamentOrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(MedicamentOrder order) throws Exception {
        MedicamentOrderEntity entity = mapper.toEntity(order);
        repository.save(entity);
    }

    @Override
    public MedicamentOrder findByOrderNumber(Long orderNumber) throws Exception {
        return repository.findById(orderNumber)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<MedicamentOrder> findOrderByPatientDocument(Long document) throws Exception {
        List<MedicamentOrderEntity> entities
                = repository.findByPatientDocument(document);

        return entities.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
