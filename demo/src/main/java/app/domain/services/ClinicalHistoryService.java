package app.domain.services;

import app.domain.model.ClinicalHistory;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.ports.ClinicalHistoryPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;
import app.infrastructure.entity.ClinicalHistoryEntity;
import app.infrastructure.repository.jpa.ClinicalHistoryRepository;
import app.infrastructure.repository.jpa.PatientRepository;
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
    @Autowired
    private ClinicalHistoryRepository repository;

    public void createClinicalHistory(ClinicalHistory history) throws Exception {
        Patient p = patientPort.findByDocument(history.getPatientDocument());
        if (p == null) {
            throw new Exception("paciente no encontrado. con el documento del paciente recibido");
        }
        if (userPort.findDoctorByDocument(history.getDoctorId()) == null) {
            throw new Exception("no existe un doctor con ese documento");
        }
        if (!userPort.findDoctorByDocument(history.getDoctorId()).getRole().equals(Role.DOCTOR)) {
            throw new Exception("El usuario buscado con id de doctor no posee el rol de doctor");
        }
        clinicalHistoryPort.save(history);
    }

    public void updateClinicalHistory(ClinicalHistory history) throws Exception {
        if (history.getPatientDocument() == null) {
            throw new Exception("documento de paciente es nulo");
        }
        ClinicalHistoryEntity entity = repository.findFirstByPatientDocument(history.getPatientDocument());
        if (entity == null) {
            throw new Exception("paciente no encontrado. No se puede actualizar historia clínica");
        }
        entity.setDate(history.getDate());
        entity.setDoctorId(history.getDoctorId());
        entity.setReasonForConsultation(history.getReasonForConsultation());
        entity.setSymptoms(history.getSymptoms());
        entity.setDiagnosis(history.getDiagnosis());
        repository.save(entity);
    }
}
