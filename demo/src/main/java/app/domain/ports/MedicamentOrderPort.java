package app.domain.ports;

import app.domain.model.MedicamentOrder;
import java.util.List;

public interface MedicamentOrderPort {

    public void save(MedicamentOrder order) throws Exception;

    public MedicamentOrder findByOrderNumber(Long orderNumber) throws Exception;

    public List<MedicamentOrder> findOrderByPatientDocument(Long document) throws Exception;
}
