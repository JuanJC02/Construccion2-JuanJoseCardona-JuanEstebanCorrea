package app.domain.services;

import app.domain.model.Visit;
import app.domain.ports.VisitPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterVisit {

    @Autowired
    private VisitPort visitPort;

    public void registerVisit(Visit visit) throws Exception {

        if (visit == null) {
            throw new Exception("no se han recibido los datos de la visita");
        }

        if (visit.getBloodOxigenLevel() == null
                || visit.getBloodPressure() == null
                || visit.getHeartRate() == null
                || visit.getTemperature() == null
                || visit.getVisitDate() == null) {
            throw new Exception("no se puede registrar la visita por falta de datos");
        }

        visitPort.save(visit);
    }
}
