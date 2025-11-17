package app.domain.services;

import app.domain.model.ClinicalHistory;
import app.domain.model.Patient;
import app.domain.ports.ClinicalHistoryPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicalHistoryService {
            
    private ClinicalHistoryPort clinicalHistoryPort;
    private PatientPort patientPort;
    private UserPort userPort;

    public void createClinicalHistory(ClinicalHistory history, Long doctorDocument) throws Exception {
        Patient p = patientPort.findByDocument(history.getPatientDocument());
        if (p == null) {
            throw new Exception("paciente no encontrado. con el documento del paciente recibido");
        }
        if(userPort.findByDocument(doctorDocument) == null) {
            throw new Exception("el documento recibido de el doctor es invalido");
        }
        history.setDoctorId(doctorDocument);
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
