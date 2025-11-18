package app.domain.ports;

import app.domain.model.Insurance;

public interface InsurancePort {

    void save(Insurance insurance) throws Exception;

    public Insurance findById(Long id) throws Exception;
}
