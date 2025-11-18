package app.adapter.out;

import app.domain.model.ProcedureOrder;
import app.domain.ports.ProcedureOrderPort;
import app.infrastructure.entity.ProcedureOrderEntity;
import app.infrastructure.mapper.ProcedureOrderMapper;
import app.infrastructure.repository.jpa.ProcedureOrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ProcedureOrderAdapter implements ProcedureOrderPort {

    private final ProcedureOrderRepository repository;
    private final ProcedureOrderMapper mapper;
    
    @Autowired
    public ProcedureOrderAdapter(ProcedureOrderRepository repository,
                                 ProcedureOrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(ProcedureOrder order) throws Exception {
        try {
            ProcedureOrderEntity entity = mapper.toEntity(order);
            repository.save(entity);
        } catch (Exception e) {
            throw new Exception("Error guardando la orden de procedimiento: " + e.getMessage());
        }
    }

    @Override
    public ProcedureOrder findByOrderNumber(Long orderNumber) throws Exception {
        return repository.findById(orderNumber)
                .map(mapper::toModel)
                .orElse(null);
    }

    @Override
    public List<ProcedureOrder> findOrderByPatientDocument(Long document) throws Exception {
        try {
            List<ProcedureOrderEntity> entities =
                    repository.findAll()
                            .stream()
                            .filter(e -> e.getPatientDocument() != null
                                    && e.getPatientDocument().equals(document))
                            .collect(Collectors.toList());

            return entities.stream()
                    .map(mapper::toModel)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new Exception("Error buscando órdenes por documento de paciente: " + e.getMessage());
        }
    }
}
