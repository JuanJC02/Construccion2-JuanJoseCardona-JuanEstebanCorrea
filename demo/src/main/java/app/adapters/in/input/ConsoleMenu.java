package app.adapters.in.input;
import app.adapters.in.input.*;
import java.util.Scanner;
import app.adapters.in.builders.*;
import app.domain.model.*;

public class ConsoleMenu {
	public void start(){
        Scanner sc = new Scanner(System.in);
        VisitInputAdapter visitAdapter = new VisitInputAdapter();
        AppointmentInputAdapter AppointmentAdapter = new AppointmentInputAdapter();
        BillInputAdapter BillAdapter = new BillInputAdapter();
        ClinicalHistoryInputAdapter Ch = new ClinicalHistoryInputAdapter();
        EmergencyContactInputAdapter EmergencyContactAdapter = new EmergencyContactInputAdapter();
        insuranceInputAdapter InsuranceAdapter = new insuranceInputAdapter();
        MedicamenOrderInputAdapter MedicalOrderAdapter = new MedicamenOrderInputAdapter();
        PatientInputAdapter PatientAdapter = new PatientInputAdapter();
        ProcedureOrderInputAdapter ProcedureAdapter = new ProcedureOrderInputAdapter();
        UserInputAdapter UserAdapter = new UserInputAdapter();
        
        
        
        
        
        int option;
        do {
            System.out.println("\n---- MENU PRINCIPAL ----");

            System.out.println("1. Crear visita");
            System.out.println("2. Crear Cita");
            System.out.println("3. Crear Factura");
            System.out.println("4. Crear Historia clinica");
            System.out.println("5. Crear contacto de emergencia");
            System.out.println("6. Crear Seguro");
            System.out.println("7. Crear Orden de medicamento");
            System.out.println("8. Crear Paciente");
            System.out.println("9. Crear Orden de procedimiento");
            System.out.println("10. Crear Usuario");
            System.out.println("11. Salir");
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            
            switch(option) {
                case 1:
                    Visit nuevaVisita = visitAdapter.BuildVisitFromConsole();
                    System.out.println("Visita creada: " + nuevaVisita);
                    break;
                case 2:
                    Appointment NewAppointment = AppointmentAdapter.buildAppointmentFromConsole();
                    System.out.println("Cita creada:" + NewAppointment);
                    break;
                case 3: 
                	Bill NewBill = BillAdapter.buildBillFromConsole();
                	System.out.println("Nueva factura creada" + NewBill);
                	break;
                case 4:	
                	ClinicalHistory NewCh = Ch.buildFromConsole();
                	System.out.println("Nueva historia clinica creada:" + NewCh);
                	break;
                case 5:
                	EmergencyContact NewEmergencyContact = EmergencyContactAdapter.buildEmergencyContactFromConsole();
                	System.out.println("nuevo contacto de emergencia creado" + NewEmergencyContact);
                	break;
                case 6:
                	Insurance NewInsurance = InsuranceAdapter.buildInsuranceFromConsole();
                	System.out.println("Nuevo seguro creado" + NewInsurance);
                	break;
                case 7:
                	//MedicamentOrder NewMedicamentOrder = MedicamenOrderInputAdapter.buildMedicamentOrderFromConsole();
                	System.out.println("Nueva orden de medicamento creada");
                	break;
                	
                case 8: 	
                	Patient NewPatient = PatientAdapter.buildPatientFromConsole();
                	System.out.println("nuevo paciente creado" + NewPatient);
                	break;
                case 9:
                	ProcedureOrder NewProcedureOrder = ProcedureAdapter.buildProcedureOrderFromConsole();
                	System.out.println("Nueva orden de procedimiento creada" + NewProcedureOrder);
                	break;
                	
                case 10:
                	User NewUser = UserAdapter.buildUserFromConsole();
                	System.out.println("Nuevo usuario creado" + NewUser);
                	break;
                case 11:
                	System.out.println("saliendo del sistema");
                	break;
                	
                
                default:
                    System.out.println("Opción inválida.");
            }
        } while(option != 11);
        
        sc.close();
    }
}


