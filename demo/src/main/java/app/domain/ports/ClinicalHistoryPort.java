package app.domain.ports;

import app.domain.model.ClinicalHistory;

public interface ClinicalHistoryPort {

    public void save(ClinicalHistory history) throws Exception;

    public ClinicalHistory findByPatientDocument(Long document) throws Exception;

    public void update(ClinicalHistory history) throws Exception;
}
