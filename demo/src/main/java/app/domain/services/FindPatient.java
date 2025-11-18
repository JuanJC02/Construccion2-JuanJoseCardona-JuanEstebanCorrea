package app.domain.services;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

public class FindPatient {

    private PatientPort patientPort;

    public Patient findPatient(Long patientDocument) throws Exception {

        if (patientDocument == null || patientDocument.toString().trim().isBlank()) {
            throw new Exception("no se ha resivido el documento de el paciente");
        }

        Patient p = patientPort.findByDocument(patientDocument);
        if (p == null) {
            throw new Exception("paciente con documento: " + patientDocument + " no encontrado");
        }
        return p;
    }
}
