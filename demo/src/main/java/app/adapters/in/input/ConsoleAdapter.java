
package app.adapters.in.input;

import app.domain.model.*;
import app.domain.services.*;
import jakarta.annotation.PostConstruct;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleAdapter {

    private final VisitInputAdapter visitAdapter;
    private final RegisterVisit registerVisit;

    @Autowired
    public ConsoleAdapter(VisitInputAdapter visitAdapter, RegisterVisit registerVisit) {
        this.visitAdapter = visitAdapter;
        this.registerVisit = registerVisit;
    }

    @PostConstruct
    public void start() throws Exception {
        showprincipalmenu();
    }
    
    public void showprincipalmenu() throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Menú Administrativo");
            System.out.println("2. Menú Doctor");
            System.out.println("3. Menú Recursos Humanos");
            System.out.println("4. Menú Enfermería");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> showadministrativemenu();
                case 2 -> showdoctormenu();
                case 3 -> showhumanresourcesmenu();
                case 4 -> shownursemenu();
                case 0 -> System.out.println("Saliendo del sistema");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    public void showadministrativemenu() {
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
                case 1 -> System.out.println("Registrar factura");
                case 2 -> System.out.println("Programar cita");
                case 3 -> System.out.println("Crear cita");
                case 4 -> System.out.println("Crear paciente");
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    public void showdoctormenu() {
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
                case 1 -> System.out.println("Crear historia clínica");
                case 2 -> System.out.println("Actualizar historia clínica");
                case 3 -> System.out.println("Crear orden de ayuda diagnóstica");
                case 4 -> System.out.println("Crear orden de medicamento");
                case 5 -> System.out.println("Crear orden de procedimiento");
                case 6 -> System.out.println("Buscar paciente");
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    public void showhumanresourcesmenu() {
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
                case 1 -> System.out.println("Crear usuario Recursos Humanos");
                case 2 -> System.out.println("Crear usuario Administrativo");
                case 3 -> System.out.println("Crear usuario Soporte de Información");
                case 4 -> System.out.println("Crear usuario Enfermería");
                case 5 -> System.out.println("Crear usuario Doctor");
                case 6 -> System.out.println("Eliminar usuario");
                case 7 -> System.out.println("Cambiar rol de usuario");
                case 8 -> System.out.println("Actualizar usuario");
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
    public void shownursemenu() throws Exception{
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
                    Visit NewVisit = visitAdapter.BuildVisitFromConsole();
                    registerVisit.registerVisit(NewVisit);
                    break;
                case 2:
                    System.out.println("Buscar paciente");
                    break;
                case 3:
                    System.out.println("Consultar órdenes");
                    break;
                case 0:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("pción inválida.");
                    break;
            }
        } while (opcion != 0);
    }
}
