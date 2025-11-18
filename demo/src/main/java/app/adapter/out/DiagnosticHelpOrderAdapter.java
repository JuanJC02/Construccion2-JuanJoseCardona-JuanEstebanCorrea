package app.adapter.out;

import app.domain.model.DiagnosticHelpOrder;
import app.domain.ports.DiagnosticHelpOrderPort;
import app.infrastructure.entity.DiagnosticHelpOrderEntity;
import app.infrastructure.mapper.DiagnosticHelpOrderMapper;
import app.infrastructure.repository.jpa.DiagnosticHelpOrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DiagnosticHelpOrderAdapter implements DiagnosticHelpOrderPort {

    private final DiagnosticHelpOrderRepository repository;
    private final DiagnosticHelpOrderMapper mapper;

    @Autowired
    public DiagnosticHelpOrderAdapter(DiagnosticHelpOrderRepository repository,
            DiagnosticHelpOrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(DiagnosticHelpOrder order) throws Exception {
        DiagnosticHelpOrderEntity entity = mapper.toEntity(order);
        repository.save(entity);
    }

    @Override
    public DiagnosticHelpOrder findByOrderNumber(Long orderNumber) throws Exception {
        DiagnosticHelpOrderEntity entity = repository.findById(orderNumber)
                .orElse(null);

        return entity != null ? mapper.toDomain(entity) : null;
    }

    @Override
    public List<DiagnosticHelpOrder> findOrderByPatientDocument(Long document) throws Exception {

        List<DiagnosticHelpOrderEntity> entities
                = repository.findByPatientDocument(document);

        return entities.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
