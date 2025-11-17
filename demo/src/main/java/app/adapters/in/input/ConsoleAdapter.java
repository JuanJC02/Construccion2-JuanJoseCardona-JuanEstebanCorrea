// ConsoleAdapter.java (modificado para agregar lógica de búsqueda y actualización)
package app.adapters.in.input;

import app.domain.model.*;
import app.domain.services.*;
import jakarta.annotation.PostConstruct;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.infrastructure.entity.PatientEntity;
import app.infrastructure.repository.jpa.PatientRepository;

@Component
public class ConsoleAdapter {

    private final VisitInputAdapter visitAdapter;
    private final RegisterVisit registerVisit;
    private final ClinicalHistoryAdapterIn clinicalHAdapter;
    private final ClinicalHistoryService clinicalHService;
    private final PatientRepository patientRepository;  // Repositorio para buscar pacientes

    @Autowired
    public ConsoleAdapter(VisitInputAdapter visitAdapter,
                          RegisterVisit registerVisit,
                          ClinicalHistoryAdapterIn clinicalHAdapter,
                          ClinicalHistoryService clinicalHService,
                          PatientRepository patientRepository) {
        
        
        
        this.visitAdapter = visitAdapter;
        this.registerVisit = registerVisit;
        this.clinicalHAdapter = clinicalHAdapter;
        this.clinicalHService = clinicalHService;
        this.patientRepository = patientRepository;
    }

    @PostConstruct
    public void start() throws Exception {
        showPrincipalMenu();
    }

    public void showPrincipalMenu() {
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
                case 1 -> showAdministrativoMenu();
                case 2 -> showDoctorMenu();
                case 3 -> showHumanResourcesMenu();
                case 4 -> showNurseMenu();
                case 0 -> System.out.println("Saliendo del sistema");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    public void showAdministrativoMenu() {
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
                case 1 -> System.out.println("Registrar factura (servicio no implementado).");
                case 2 -> System.out.println("Programar cita (servicio no implementado).");
                case 3 -> System.out.println("Crear cita (servicio no implementado).");
                case 4 -> System.out.println("Crear paciente (servicio no implementado).");
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
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
                        clinicalHService.createClinicalHistory(nueva);
                        System.out.println("Historia clínica creada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    ClinicalHistory actual = clinicalHAdapter.buildHistoryFromConsole();
                    try {
                        clinicalHService.updateClinicalHistory(actual);
                        System.out.println("Historia clínica actualizada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Crear orden de ayuda diagnóstica (servicio no implementado).");
                    break;
                case 4:
                    System.out.println("Crear orden de medicamento (servicio no implementado).");
                    break;
                case 5:
                    System.out.println("Crear orden de procedimiento (servicio no implementado).");
                    break;
                case 6:
                    System.out.print("Ingrese el documento del paciente a buscar: ");
                    Long doc = scanner.nextLong();
                    // Buscar paciente en BD
                    PatientEntity paciente = patientRepository.findByDocument(doc).orElse(null);
                    if (paciente != null) {
                        System.out.println("Paciente encontrado: " 
                            + paciente.getName() + " " + paciente.getLastName());
                    } else {
                        System.out.println("Paciente no encontrado.");
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

    public void showHumanResourcesMenu() {
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
                case 1 -> System.out.println("Crear usuario Recursos Humanos (servicio no implementado).");
                case 2 -> System.out.println("Crear usuario Administrativo (servicio no implementado).");
                case 3 -> System.out.println("Crear usuario Soporte de Información (servicio no implementado).");
                case 4 -> System.out.println("Crear usuario Enfermería (servicio no implementado).");
                case 5 -> System.out.println("Crear usuario Doctor (servicio no implementado).");
                case 6 -> System.out.println("Eliminar usuario (servicio no implementado).");
                case 7 -> System.out.println("Cambiar rol de usuario (servicio no implementado).");
                case 8 -> System.out.println("Actualizar usuario (servicio no implementado).");
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
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
                        registerVisit.registerVisit(nuevaVisita);
                        System.out.println("Visita registrada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el documento del paciente a buscar: ");
                    Long doc2 = scanner.nextLong();
                    // Buscar paciente en BD
                    PatientEntity paciente2 = patientRepository.findByDocument(doc2).orElse(null);
                    if (paciente2 != null) {
                        System.out.println("Paciente encontrado: " 
                            + paciente2.getName() + " " + paciente2.getLastName());
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Consultar órdenes (servicio no implementado).");
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
