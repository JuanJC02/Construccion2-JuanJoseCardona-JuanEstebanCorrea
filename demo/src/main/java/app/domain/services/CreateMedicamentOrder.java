package app.domain.services;

import app.domain.model.MedicamentOrder;
import app.domain.model.Patient;
import app.domain.ports.MedicamentOrderPort;
import app.domain.ports.PatientPort;

public class CreateMedicamentOrder {

    private MedicamentOrderPort medicamentOrderPort;
    private PatientPort patientPort;

    public void createMedicamentOrder(Long patientDocument, MedicamentOrder order) throws Exception {
        if (patientDocument == null || patientDocument.toString().trim().isBlank()) {
            throw new Exception("no se ha recivido el documento de el paciente");
        }

        Patient p = patientPort.findByDocument(patientDocument);
        if (p == null) {
            throw new Exception("paciente no encontrado. Registra el paciente antes de crear la orden de medicamento");
        }
        
        if(order.getPatientDocument() == null || order.getPatientDocument().toString().trim().isBlank()) {
            order.setPatientDocument(patientDocument);
        }

        medicamentOrderPort.save(order);
    }
}
