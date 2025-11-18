package app.domain.services;

import app.domain.model.MedicamentOrder;
import app.domain.model.Patient;
import app.domain.ports.MedicamentOrderPort;
import app.domain.ports.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMedicamentOrder {

    @Autowired
    private MedicamentOrderPort medicamentOrderPort;
    @Autowired
    private PatientPort patientPort;

    public void createMedicamentOrder(MedicamentOrder order) throws Exception {
        Patient p = patientPort.findByDocument(order.getPatientDocument());
        if (p == null) {
            throw new Exception("paciente no encontrado con el documento de la orden");
        }

        medicamentOrderPort.save(order);
    }
}
