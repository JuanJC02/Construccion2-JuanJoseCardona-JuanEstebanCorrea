
package app.domain.ports;

import app.domain.model.Appointment;
import java.util.List;

public interface AppointmentPort {
    List<Appointment> findByPatientDocument(String patientDocument) throws Exception;
    public Appointment findAppointmentByDocument(Appointment appointment) throws Exception;
    public void save(Appointment appointment) throws Exception;
}
