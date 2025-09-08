package app.domain.services;

import app.domain.model.Bill;
import app.domain.model.Appointment;
import app.domain.model.Insurance;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.BillPort;
import app.domain.ports.InsurancePort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;
import java.sql.Date;

public class CreateBill {

    private BillPort billPort;
    private UserPort userPort;
    private PatientPort patientPort;
    private InsurancePort insurancePort;

    public void registerBill(User actor, Bill bill) throws Exception {
        User actor1 = userPort.findByActor(actor);
        if (actor1 == null) {
            throw new Exception("actor no encontrado: no se pueden hacer modificaciones");
        }
        if (!actor1.getRole().equals(Role.ADMINISTRATIVE_STAFF)) {
            throw new Exception("el actor no tiene Permisos para modificar los datos");
        }

        if (bill == null) {
            throw new Exception("no hay factura");
        }

        Appointment appointment = bill.getAppointment();
        if (appointment == null) {
            throw new Exception("la factura debe tener una cita adjunta");
        }

        Patient patient = patientPort.findByDocument(appointment.getPatient().getDocument());
        if (patient == null) {
            throw new Exception("la cita debe tener un paciente asociado");
        }

        if (patient.getName() == null || patient.getName().trim().isEmpty()) {
            throw new Exception("el paciente no tiene un nombre asociado");
        }
        if (patient.getDocument() == null) {
            throw new Exception("el paciente no posee un documento asociado");
        }
        if (!appointment.getAttendingPhysician().getRole().equals(Role.DOCTOR)) {
            throw new Exception("la cita debe tener un medico asociado");
        }

        Insurance patientInsurance = insurancePort.findById(patient.getDocument());
        if (patientInsurance == null) {
            throw new Exception("el paciente no tiene un seguro");
        }
        if (patientInsurance.getCompanyName() == null || patientInsurance.getCompanyName().trim().isEmpty()) {
            throw new Exception("se requiere el nombre de la compañia de seguros de el paciente");
        }
        if (patientInsurance.getPolicyNumber() == null) {
            throw new Exception("se requiere el numero de poliza de el paciente");
        }
        if (patientInsurance.getPolicyExpirationDate() == null) {
            throw new Exception("se requiere la fecha de expiracion de la poliza de el paciente");
        }

        Date apDate = appointment.getAppointmentDate();
        if (apDate == null) {
            throw new Exception("se debe programar la cita antes de crear la factura");
        }
        
        /*
        Patient found;
        try {
            found = patientPort.findByPatient(patient);
        } catch (Exception e) {
            found = null;
        }

        if (found == null) {
            throw new Exception("paciente no encontrado. Registra un nuevo paciente antes de registrar una factura");
        }
        */
        
        billPort.save(bill);
    }
}
