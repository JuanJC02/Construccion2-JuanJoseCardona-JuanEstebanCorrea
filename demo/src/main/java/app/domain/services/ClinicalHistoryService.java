package app.domain.services;

import app.domain.model.ClinicalHistory;
import app.domain.model.Patient;
import app.domain.ports.ClinicalHistoryPort;
import app.domain.ports.PatientPort;

public class ClinicalHistoryService {

    private ClinicalHistoryPort clinicalHistoryPort;
    private PatientPort patientPort;

    public void createClinicalHistory(Long patientDocument, ClinicalHistory history) throws Exception {
        if (patientDocument == null) {
            throw new Exception("documento de paciente es nulo");
        }

        Patient p = patientPort.findByDocument(patientDocument);
        if (p == null) {
            throw new Exception("paciente no encontrado. Registra el paciente antes de crear la historia clinica");
        }

        clinicalHistoryPort.save(history);
    }

    public void updateClinicalHistory(Long patientDocument, ClinicalHistory history) throws Exception {
        if (patientDocument == null) {
            throw new Exception("documento de paciente es nulo");
        }

        Patient p = patientPort.findByDocument(patientDocument);
        if (p == null) {
            throw new Exception("paciente no encontrado. No se puede actualizar historia clinica");
        }

        clinicalHistoryPort.update(history);
    }
}
