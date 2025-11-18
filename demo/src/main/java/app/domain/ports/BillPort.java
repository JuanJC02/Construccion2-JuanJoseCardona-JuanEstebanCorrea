package app.domain.ports;

import app.domain.model.Bill;
import java.util.List;

public interface BillPort {

    public void save(Bill bill) throws Exception;

    public Bill findById(Long id) throws Exception;

    public int sumCopaysByPatientAndYear(Long patientDocument, int year) throws Exception;

    List<Bill> findByPatientAndYear(Long patientDocument, int year) throws Exception;
}
