package app.domain.ports;

import app.domain.model.Patient;

public interface PatientPort {

    public Patient findByPatient(Patient patient) throws Exception;

    public Patient findByDocument(Long document) throws Exception;

    public void save(Patient patient) throws Exception;
}
