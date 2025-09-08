package app.domain.services;

import app.domain.model.User;
import app.domain.model.Visit;
import app.domain.model.enums.Role;
import app.domain.ports.UserPort;
import app.domain.ports.VisitPort;

public class RegisterVisit {

    private UserPort userPort;
    private VisitPort visitPort;

    public void registerVisit(User actor, Visit visit) throws Exception {
        User actor1 = userPort.findByActor(actor);
        if (actor1 == null) {
            throw new Exception("actor no encontrado: no se pueden modificar los datos");
        }
        if (!actor1.getRole().equals(Role.NURSE)) {
            throw new Exception("el actor no tiene Permisos para modificar los datos");
        }
        
        if (visit == null) {
            throw new Exception("no hay visita");
        }
        
        Visit v = visitPort.findVisitByPatientId(visit.getPatientToVisit().getDocument());
        
        if(v.getBloodOxigenLevel() == null || v.getBloodPressure() == null ||
           v.getPatientToVisit() == null || v.getHeartRate() == null || 
           v.getTemperature() == null || v.getVisitDate() == null) {
            throw new Exception("no se puede registrar la visita por falta de datos");
        }
        visitPort.save(visit);
    }
}
