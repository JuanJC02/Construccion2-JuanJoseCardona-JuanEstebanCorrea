package app.adapter.out;

import app.domain.model.Bill;
import app.domain.ports.BillPort;
import app.infrastructure.entity.BillEntity;
import app.infrastructure.mapper.BillMapper;
import app.infrastructure.repository.jpa.BillRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillAdapter implements BillPort {

    private final BillRepository repository;
    private final BillMapper mapper;

    @Autowired
    public BillAdapter(BillRepository repository, BillMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(Bill bill) throws Exception {
        if (bill == null) {
            throw new Exception("No se ha recibido la factura para guardar");
        }

        BillEntity entity = BillMapper.toEntity(bill);
        repository.save(entity);
    }

    @Override
    public Bill findById(Long id) throws Exception {
        BillEntity entity = repository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró una factura con ID: " + id));

        return BillMapper.toDomain(entity);
    }

    @Override
    public int sumCopaysByPatientAndYear(Long patientDocument, int year) throws Exception {
        List<Bill> bills = findByPatientAndYear(patientDocument, year);

        //aqui para coopago 
        return 0;
    }

    @Override
    public List<Bill> findByPatientAndYear(Long patientDocument, int year) throws Exception {
        if (patientDocument == null) {
            throw new Exception("No se recibió el documento del paciente");
        }

        List<BillEntity> billEntities = repository.findByPatientDocument(patientDocument);

        return billEntities.stream()
                .map(BillMapper::toDomain)
                .filter(b -> b.getPolicyExpirationDate() != null
                && b.getPolicyExpirationDate().getYear() == year)
                .collect(Collectors.toList());
    }
}
