package app.domain.ports;

import app.domain.model.ProcedureOrder;
import java.util.List;

public interface ProcedureOrderPort {

    public void save(ProcedureOrder order) throws Exception;

    public ProcedureOrder findByOrderNumber(Long orderNumber) throws Exception;

    public List<ProcedureOrder> findOrderByPatientDocument(Long document) throws Exception;
}
