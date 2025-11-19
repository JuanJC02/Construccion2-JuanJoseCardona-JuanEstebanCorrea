//Intercambiar para que se use casos de uso en lugar de servicios directamente
package app.adapters.in.input;

import app.adapter.out.BillAdapter;
import app.domain.model.*;
import app.domain.model.enums.Role;
import app.domain.ports.DiagnosticHelpOrderPort;
import app.domain.ports.MedicamentOrderPort;
import app.domain.ports.ProcedureOrderPort;
import app.domain.ports.UserPort;
import app.domain.services.*;
import app.domain.usecase.AdministrativeStaffUseCase;
import app.domain.usecase.DoctorUseCase;
import app.domain.usecase.HumanResourcesUseCase;
import app.domain.usecase.NurseUseCase;
import jakarta.annotation.PostConstruct;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.infrastructure.entity.PatientEntity;
import app.infrastructure.entity.UserEntity;
import app.infrastructure.mapper.UserMapper;
import app.infrastructure.repository.jpa.*;
import java.sql.Date;

@Component
public class ConsoleAdapter {
    
    
    private final AdministrativeStaffUseCase administrativeStaffUseCase;
    private UserPort userPort;
    private final DoctorUseCase doctorUseCase;
    private final HumanResourcesUseCase humanResourcesUseCase;
    private final NurseUseCase nurseUseCase;
    
    private final VisitInputAdapter visitAdapter;
    private final RegisterVisit registerVisit;
    private final ClinicalHistoryAdapterIn clinicalHAdapter;
    private final ClinicalHistoryService clinicalHService;
    private final PatientRepository patientRepository;
    private final PatientInputAdapter patientInputAdapter;
    private final CreatePatient createPatient;
    private final UserRepository userRepository;
    private final UserInputAdapter userInputAdapter;
    private final CreateUser createUser;
    private final AppointmentInputAdapter apAdapter;
    private final CreateAppointment createAppointment;
    private final BillInputAdapter billInputAdapter;
    private final CreateBill createBill;
    private final DiagnosticHelpOrderInputAdapter diagnosticHelpOrderInputAdapter;
    private final CreateDiagnosticHelpOrder createDiagnosticHelpOrder;
    private final MedicamentOrderInputAdapter medicamentOrderInputAdapter;
    private final CreateMedicamentOrder createMedicamentOrder;
    private final ProcedureOrderInputAdapter procedureOrderInputAdapter;
    private final CreateProcedureOrder createProcedureOrder;
    private final DeleteUser deleteUser;
    private final UserMapper uMapper;
    private final RolManager rolManager;
    private final UpdateUser updateUser;
    private final ScheduleAppointment scheduleAppointment;
    private final DiagnosticHelpOrderRepository diagnosticHelpOrderRepository;
    private final FindOrders findOrders;
    private final MedicamentOrderPort medicamentOrderPort;
    private final ProcedureOrderPort procedureOrderPort;
    private final DiagnosticHelpOrderPort diagnosticHelpOrderPort;
    private final RoleValidator roleValidator;

    @Autowired
    public ConsoleAdapter(VisitInputAdapter visitAdapter,
            RegisterVisit registerVisit,
            ClinicalHistoryAdapterIn clinicalHAdapter,
            ClinicalHistoryService clinicalHService,
            PatientRepository patientRepository,
            PatientInputAdapter patientInputAdapter,
            CreatePatient createPatient,
            AppointmentInputAdapter apAdapter,
            CreateAppointment createAppointment,
            BillInputAdapter billInputAdapter,
            CreateBill createBill,
            DiagnosticHelpOrderInputAdapter diagnosticHelpOrderInputAdapter,
            CreateDiagnosticHelpOrder createDiagnosticHelpOrder,
            MedicamentOrderInputAdapter medicamentOrderInputAdapter,
            CreateMedicamentOrder createMedicamentOrder,
            ProcedureOrderInputAdapter procedureOrderInputAdapter,
            CreateProcedureOrder createProcedureOrder,
            UserInputAdapter userInputAdapter,
            CreateUser createUser,
            DeleteUser deleteUser,
            UserRepository userRepository,
            UserMapper uMapper,
            RolManager rolManager,
            UpdateUser updateUser,
            ScheduleAppointment scheduleAppointment,
            DiagnosticHelpOrderRepository diagnosticHelpOrderRepository,
            FindOrders findOrders,
            MedicamentOrderPort medicamentOrderPort,
            ProcedureOrderPort procedureOrderPort,
            DiagnosticHelpOrderPort diagnosticHelpOrderPort,
            RoleValidator roleValidator,
            AdministrativeStaffUseCase administrativeStaffUseCase,
            DoctorUseCase doctorUseCase,
            HumanResourcesUseCase humanResourcesUseCase,
            NurseUseCase nurseUseCase) {

        this.visitAdapter = visitAdapter;
        this.registerVisit = registerVisit;
        this.clinicalHAdapter = clinicalHAdapter;
        this.clinicalHService = clinicalHService;
        this.patientRepository = patientRepository;
        this.patientInputAdapter = patientInputAdapter;
        this.createPatient = createPatient;
        this.userRepository = userRepository;
        this.apAdapter = apAdapter;
        this.createAppointment = createAppointment;
        this.billInputAdapter = billInputAdapter;
        this.createBill = createBill;
        this.diagnosticHelpOrderInputAdapter = diagnosticHelpOrderInputAdapter;
        this.createDiagnosticHelpOrder = createDiagnosticHelpOrder;
        this.medicamentOrderInputAdapter = medicamentOrderInputAdapter;
        this.createMedicamentOrder = createMedicamentOrder;
        this.procedureOrderInputAdapter = procedureOrderInputAdapter;
        this.createProcedureOrder = createProcedureOrder;
        this.userInputAdapter = userInputAdapter;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.uMapper = uMapper;
        this.rolManager = rolManager;
        this.updateUser = updateUser;
        this.scheduleAppointment = scheduleAppointment;
        this.diagnosticHelpOrderRepository = diagnosticHelpOrderRepository;
        this.findOrders = findOrders;
        this.medicamentOrderPort = medicamentOrderPort;
        this.procedureOrderPort = procedureOrderPort;
        this.diagnosticHelpOrderPort = diagnosticHelpOrderPort;
        this.roleValidator = roleValidator;
        this.administrativeStaffUseCase = administrativeStaffUseCase;
        this.doctorUseCase = doctorUseCase;
        this.humanResourcesUseCase = humanResourcesUseCase;
        this.nurseUseCase = nurseUseCase;
    }

    @PostConstruct
    public void start() throws Exception {
        showLogin();
    }
    User u;
    public void showLogin() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el documento de quien usara el programa: ");
        Long s = scanner.nextLong();
        if(roleValidator.Validar(s)) {
            u = userPort.findByDocument(s);
            showPrincipalMenu();
        } else {
            u = userInputAdapter.buildUserFromConsole();
            u.setRole(Role.DEVELOP);
            userPort.save(u);
        }
    }
  
   

    public void showPrincipalMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Administrativo");
            System.out.println("2. Doctor");
            System.out.println("3. Recursos Humanos");
            System.out.println("4. Enfermería");
            System.out.println("0. Salir del sistema");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 ->
                    showAdministrativoMenu();
                case 2 ->
                    showDoctorMenu();
                case 3 ->
                    showHumanResourcesMenu();
                case 4 ->
                    showNurseMenu();
                case 0 ->
                    System.out.println("Saliendo del sistema");
                default ->
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    public void showAdministrativoMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== MENÚ ADMINISTRATIVO ===");
            System.out.println("1. Registrar factura");
            System.out.println("2. Programar cita");
            System.out.println("3. Crear cita");
            System.out.println("4. Crear paciente");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Bill bill = billInputAdapter.buildBillFromConsole();
                    try {
                        administrativeStaffUseCase.registerBill(u.getDocument(), bill);
                        System.out.println("Factura creada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el ID de la cita a programar: ");
                    Long idCita = scanner.nextLong();

                    System.out.print("Ingrese la fecha de la cita (YYYY-MM-DD): ");
                    String fecha = scanner.next();

                    Date fechaSQL = Date.valueOf(fecha);

                    try {
                        administrativeStaffUseCase.scheduleAppointment(u.getDocument(),idCita, fechaSQL);
                        System.out.println("La cita ha sido programada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al programar cita: " + e.getMessage());
                    }
                    break;
                case 3:
                    Appointment nuevo = apAdapter.buildAppointmentFromConsole();
                    try {
                        administrativeStaffUseCase.createAppointment(u.getDocument(), nuevo);
                        System.out.println("Cita creada correctamente.");
                        System.out.println("Ahora tienes que programarla.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    Patient patient = patientInputAdapter.buildPatientFromConsole();
                    try {
                        administrativeStaffUseCase.createPatient(u.getDocument(), patient);
                        System.out.println("paciente creado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    public void showDoctorMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== MENÚ DOCTOR ===");
            System.out.println("1. Crear historia clínica");
            System.out.println("2. Actualizar historia clínica");
            System.out.println("3. Crear orden de ayuda diagnóstica");
            System.out.println("4. Crear orden de medicamento");
            System.out.println("5. Crear orden de procedimiento");
            System.out.println("6. Buscar paciente");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ClinicalHistory nueva = clinicalHAdapter.buildHistoryFromConsole();
                    try {
                        doctorUseCase.createClinicalHistory(u.getDocument(), nueva);
                        System.out.println("Historia clínica creada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    ClinicalHistory actual = clinicalHAdapter.buildHistoryFromConsole();
                    try {
                        doctorUseCase.updateClinicalHistory(u.getDocument(), actual);
                        System.out.println("Historia clínica actualizada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    DiagnosticHelpOrder diagOrder = diagnosticHelpOrderInputAdapter.buildDiagnosticHelpOrderFromConsole();
                    try {
                        doctorUseCase.createDiagnosticHelpOrder(u.getDocument(), diagOrder);
                        System.out.println("orden de ayuda en el diagnostico creada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    MedicamentOrder medOrder = medicamentOrderInputAdapter.buildMedicalOrderFromConsole();
                    try {
                        doctorUseCase.createMedicamentOrder(u.getDocument(), medOrder);
                        System.out.println("orden de medicamento creada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    ProcedureOrder proceOrder = procedureOrderInputAdapter.buildProcedureOrderFromConsole();
                    try {
                        doctorUseCase.createProcedureOrder(u.getDocument(), proceOrder);
                        System.out.println("La orden de procedimiento medico ha sido creada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    if(u.getRole() == Role.DOCTOR || u.getRole() == Role.DEVELOP){
                    System.out.print("Ingrese el documento del paciente a buscar: ");
                    Long doc = scanner.nextLong();
                    PatientEntity paciente = patientRepository.findByDocument(doc).orElse(null);
                    if (paciente != null) {
                        System.out.println("Paciente encontrado: "
                                + paciente.getName() + " " + paciente.getLastName());
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    } else {
                        System.out.println("Sin Permisos.");
                    }
                    break;
                case 0:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    public void showHumanResourcesMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== MENÚ RECURSOS HUMANOS ===");
            System.out.println("1. Crear usuario Recursos Humanos");
            System.out.println("2. Crear usuario Administrativo");
            System.out.println("3. Crear usuario Soporte de Información");
            System.out.println("4. Crear usuario Enfermería");
            System.out.println("5. Crear usuario Doctor");
            System.out.println("6. Eliminar usuario");
            System.out.println("7. Cambiar rol de usuario");
            System.out.println("8. Actualizar usuario");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    User rhUser = userInputAdapter.buildUserFromConsole();
                    try {
                        rhUser.setRole(Role.HUMAN_RESOURCES);
                        humanResourcesUseCase.createHumanResourcesUser(u.getDocument(), rhUser);
                        System.out.println("El usuario ha sido creado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    User adUser = userInputAdapter.buildUserFromConsole();
                    try {
                        adUser.setRole(Role.ADMINISTRATIVE_STAFF);
                        humanResourcesUseCase.createAdministrativeStaffUser(u.getDocument(), adUser);
                        System.out.println("El usuario ha sido creado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    User iUser = userInputAdapter.buildUserFromConsole();
                    try {
                        iUser.setRole(Role.INFORMATION_SUPPORT);
                        humanResourcesUseCase.createInformationSupportUser(u.getDocument(), iUser);
                        System.out.println("El usuario ha sido creado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    User eUser = userInputAdapter.buildUserFromConsole();
                    try {
                        eUser.setRole(Role.NURSE);
                        humanResourcesUseCase.createNurseUser(u.getDocument(), eUser);
                        System.out.println("El usuario ha sido creado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    User dUser = userInputAdapter.buildUserFromConsole();
                    try {
                        dUser.setRole(Role.DOCTOR);
                        humanResourcesUseCase.createDoctorUser(u.getDocument(), dUser);
                        System.out.println("El usuario ha sido creado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    if(u.getRole() == Role.HUMAN_RESOURCES || u.getRole() == Role.DEVELOP) {
                    System.out.print("Ingrese el documento del usuario a Eliminar: ");
                    Long doc = scanner.nextLong();
                    UserEntity user = userRepository.findByDocument(doc).orElse(null);
                    if (user == null) {
                        throw new Exception("No se ha encontrado usuario para eliminar con ese documento");
                    }
                    deleteUser.delete(uMapper.toModel(user));
                    System.out.println("Usuario Eliminado Satisfactoriamente");
                    } else {
                        System.out.println("Sin Permisos");
                    }
                    break;
                case 7:
                    if(u.getRole() == Role.HUMAN_RESOURCES || u.getRole() == Role.DEVELOP){
                    System.out.print("Ingrese el documento del usuario: ");
                    Long doc3 = scanner.nextLong();

                    System.out.println("Seleccione el nuevo rol:");
                    for (Role r : Role.values()) {
                        System.out.println(r.ordinal() + 1 + ". " + r);
                    }
                    System.out.print("Opción: ");
                    int rolOption = scanner.nextInt();

                    if (rolOption < 1 || rolOption > Role.values().length) {
                        System.out.println("Rol inválido.");
                        break;
                    }
                    Role selectedRole = Role.values()[rolOption - 1];
                    try {
                        System.out.println("Cambiando rol...");
                        rolManager.changeRole(doc3, selectedRole);
                        System.out.println("El rol ha sido actualizado correctamente.");

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    } else {
                        System.out.println("Falta de Permisos");
                    }
                    break;
                case 8:
                    if(u.getRole() == Role.HUMAN_RESOURCES || u.getRole() == Role.DEVELOP) {
                    System.out.print("Ingrese el documento del usuario a actualizar: ");
                    Long docUpdate = scanner.nextLong();
                    scanner.nextLine();

                    UserEntity ue = userRepository.findByDocument(docUpdate).orElse(null);
                    if (ue == null) {
                        System.out.println("Usuario no encontrado.");
                        break;
                    }

                    User existingUser = uMapper.toModel(ue);
                    User updated = new User();
                    updated.setDocument(existingUser.getDocument());

                    System.out.println("Ingrese nuevo username (ENTER para no cambiar): ");
                    String username = scanner.nextLine();
                    if (!username.isBlank()) {
                        updated.setUsername(username);
                    }

                    System.out.println("Ingrese nuevo password (ENTER para no cambiar): ");
                    String pass = scanner.nextLine();
                    if (!pass.isBlank()) {
                        updated.setPassword(pass);
                    }

                    System.out.println("Ingrese nuevo nombre (ENTER para no cambiar): ");
                    String name = scanner.nextLine();
                    if (!name.isBlank()) {
                        updated.setName(name);
                    }

                    System.out.println("Ingrese nuevo apellido (ENTER para no cambiar): ");
                    String last = scanner.nextLine();
                    if (!last.isBlank()) {
                        updated.setLastName(last);
                    }

                    System.out.println("Ingrese nuevo email (ENTER para no cambiar): ");
                    String email = scanner.nextLine();
                    if (!email.isBlank()) {
                        updated.setEmail(email);
                    }

                    System.out.println("Ingrese nuevo telefono (ENTER para no cambiar): ");
                    String phone = scanner.nextLine();
                    if (!phone.isBlank()) {
                        updated.setPhonenumber(phone);
                    }

                    System.out.println("Ingrese nueva dirección (ENTER para no cambiar): ");
                    String address = scanner.nextLine();
                    if (!address.isBlank()) {
                        updated.setAddress(address);
                    }

                    try {
                        updateUser.updateUser(updated);
                        System.out.println("Usuario actualizado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    } else {
                        System.out.println("Falta de Permisos");
                    }
                    break;
                case 0:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    public void showNurseMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== MENÚ ENFERMERÍA ===");
            System.out.println("1. Registrar visita");
            System.out.println("2. Buscar paciente");
            System.out.println("3. Consultar órdenes");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Visit nuevaVisita = visitAdapter.BuildVisitFromConsole();
                    try {
                        nurseUseCase.registerVisit(u.getDocument(), nuevaVisita);
                        System.out.println("Visita registrada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    if(u.getRole() == Role.NURSE || u.getRole() == Role.DEVELOP) {
                    System.out.print("Ingrese el documento del paciente a buscar: ");
                    Long doc2 = scanner.nextLong();
                    PatientEntity paciente2 = patientRepository.findByDocument(doc2).orElse(null);
                    if (paciente2 != null) {
                        System.out.println("Paciente encontrado: "
                                + paciente2.getName() + " " + paciente2.getLastName());
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    } else {
                        System.out.println("Falta de Permisos");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Ingrese el documento del paciente: ");
                        Long docP = scanner.nextLong();

                        System.out.println("Seleccione el tipo de orden a consultar:");
                        System.out.println("1. Ordenes de Medicamento");
                        System.out.println("2. Ordenes de Procedimiento");
                        System.out.println("3. Ordenes de Ayuda Diagnóstica");
                        System.out.print("Opción: ");
                        int tipo = scanner.nextInt();

                        String orderType = null;

                        switch (tipo) {
                            case 1:
                                orderType = "MEDICAMENT";
                                break;
                            case 2:
                                orderType = "PROCEDURE";
                                break;
                            case 3:
                                orderType = "DIAGNOSTICHELP";
                                break;
                            default: {
                                System.out.println("Tipo inválido.");
                                break;
                            }
                        }

                        if (orderType == null) {
                            break;
                        }

                        FindOrders findOrdersService = new FindOrders(
                                medicamentOrderPort,
                                procedureOrderPort,
                                diagnosticHelpOrderPort
                        );

                        var orders = nurseUseCase.findOrders(u.getDocument(), docP, orderType);

                        if (orders.isEmpty()) {
                            System.out.println("No se encontraron órdenes para este paciente.");
                        } else {
                            System.out.println("\n--- Órdenes Encontradas (" + orderType + ") ---");
                            orders.forEach(o -> System.out.println(o.toString()));
                        }

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }
}
