package app.domain.services;

import app.domain.Utilities.GenerateRandomId;
import app.domain.model.MedicamentOrder;
import app.domain.model.Patient;
import app.domain.ports.MedicamentOrderPort;
import app.domain.ports.PatientPort;

public class CreateMedicamentOrder {

    private MedicamentOrderPort medicamentOrderPort;
    private PatientPort patientPort;
    private GenerateRandomId generateRandomId;

    public void createMedicamentOrder(MedicamentOrder order) throws Exception {
        Patient p = patientPort.findByDocument(order.getPatientDocument());
        if (p == null) {
            throw new Exception("paciente no encontrado con el documento de la orden");
        }
        if (order.getOrderId() == null || order.getOrderId().toString().trim().isBlank()) {
            order.setOrderId(generateRandomId.generateRandomId());
        }

        medicamentOrderPort.save(order);
    }
}
