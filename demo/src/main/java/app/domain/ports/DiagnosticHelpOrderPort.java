package app.domain.ports;

import app.domain.model.DiagnosticHelpOrder;
import java.util.List;

public interface DiagnosticHelpOrderPort {

    public void save(DiagnosticHelpOrder order) throws Exception;

    public DiagnosticHelpOrder findByOrderNumber(Long orderNumber) throws Exception;

    public List<DiagnosticHelpOrder> findOrderByPatientDocument(Long document) throws Exception;
}
