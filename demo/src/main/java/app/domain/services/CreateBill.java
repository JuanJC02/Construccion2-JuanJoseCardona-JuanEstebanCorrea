package app.domain.services;

import app.domain.model.Bill;
import app.domain.model.Insurance;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.ports.BillPort;
import app.domain.ports.InsurancePort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class CreateBill {

    private BillPort billPort;
    private PatientPort patientPort;
    private InsurancePort insurancePort;
    private UserPort userPort;

    public void registerBill(Bill bill, Long treatingPhysicianDocument) throws Exception {
        //builder minimo patientDocument, treatingPhysicianDocument 
        if (treatingPhysicianDocument == null || treatingPhysicianDocument.toString().trim().isBlank()) {
            throw new Exception("No se ha recibido el documento de el medico tratante");
        }
        if (bill == null) {
            throw new Exception("no se ha recibido una factura");
        }

        Patient patient = patientPort.findByDocument(bill.getPatientDocument());
        if (patient == null) {
            throw new Exception("no se ha encontrado un paciente con el documento recibido de la factura");
        }

        if (bill.getTreatingPhysicianDocument() == null || bill.getTreatingPhysicianDocument().toString().trim().isBlank()) {
            bill.setTreatingPhysicianDocument(treatingPhysicianDocument);
        }

        if (userPort.findDoctorByDocument(treatingPhysicianDocument) == null) {
            throw new Exception("no se ha encontrado un usuario con el documento del medico tratante");
        }

        if (!userPort.findDoctorByDocument(treatingPhysicianDocument).getRole().equals(Role.DOCTOR)) {
            throw new Exception("el medico tratante no cumple con el rol necesario");
        }

        if (patient.getPolicyNumber() != null) {
            Insurance patientInsurance = insurancePort.findById(patient.getPolicyNumber());

            if (patientInsurance == null) {
                throw new Exception("no se ha encontrado un seguro con el numero de poliza recibido");
            }

            bill.setCompanyName(patientInsurance.getCompanyName());
            bill.setPolicyExpirationDate(patientInsurance.getPolicyExpirationDate());
        }

        bill.setPatientName(patient.getName());
        bill.setPatientLastName(patient.getName());
        bill.setPatientAge(patient.getAge());

        billPort.save(bill);
    }
}
