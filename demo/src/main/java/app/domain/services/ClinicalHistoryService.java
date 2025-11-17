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
    @Autowired
    private ClinicalHistoryPort clinicalHistoryPort;
    @Autowired
    private PatientPort patientPort;
    @Autowired
    private UserPort userPort;

    public void createClinicalHistory(ClinicalHistory history) throws Exception {
        Patient p = patientPort.findByDocument(history.getPatientDocument());
        if (p == null) {
            throw new Exception("paciente no encontrado. con el documento del paciente recibido");
        }
        if(userPort.findByDocument(history.getDoctorId()) == null) {
            throw new Exception("no existe un doctor con ese documento");
        }
        clinicalHistoryPort.save(history);
    }

    public void updateClinicalHistory(ClinicalHistory history) throws Exception {
        if (history.getPatientDocument() == null) {
            throw new Exception("documento de paciente es nulo");
        }

        Patient p = patientPort.findByDocument(history.getPatientDocument());
        if (p == null) {
            throw new Exception("paciente no encontrado. No se puede actualizar historia clinica");
        }

        clinicalHistoryPort.save(history);//pendiente para Update
    }
}
