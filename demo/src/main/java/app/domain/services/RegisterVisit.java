package app.domain.services;

import app.domain.model.Visit;
import app.domain.ports.VisitPort;

public class RegisterVisit {

    private VisitPort visitPort;

    public void registerVisit(Visit visit) throws Exception {
        
        if (visit == null) {
            throw new Exception("no se han recibido los datos de la visita");
        }
        
        Visit v = visitPort.findVisitByPatientId(visit.getPatientToVisitDocument());
        
        if(v.getBloodOxigenLevel() == null ||
           v.getBloodPressure() == null ||
           v.getHeartRate() == null || 
           v.getTemperature() == null || 
           v.getVisitDate() == null) {
            throw new Exception("no se puede registrar la visita por falta de datos");
        }
        visitPort.save(visit);
    }
}
