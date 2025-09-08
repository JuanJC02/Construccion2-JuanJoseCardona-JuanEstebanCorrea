
package app.domain.ports;

import app.domain.model.Visit;

public interface VisitPort {
    public void save(Visit visit) throws Exception;
    public Visit findVisitByPatientId(Long document) throws Exception;
}
