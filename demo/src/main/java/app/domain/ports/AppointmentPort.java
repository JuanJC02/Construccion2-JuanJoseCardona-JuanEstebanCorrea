
package app.domain.ports;

import app.domain.model.Appointment;
import java.util.List;

public interface AppointmentPort {
    List<Appointment> findByPatientDocument(String patientDocument) throws Exception;
    public Appointment findAppointmentByDocument(Long document) throws Exception;
    public Long findAppointmentIdById(Long appointmentID) throws Exception;
    public void save(Appointment appointment) throws Exception;
}
