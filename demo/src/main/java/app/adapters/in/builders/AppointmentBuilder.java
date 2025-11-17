package app.adapters.in.builders;

import app.domain.model.Appointment;
import java.util.Scanner;

public class AppointmentBuilder {

    private final Scanner sc = new Scanner(System.in);

    public Appointment buildFromConsole() {
        Appointment a = new Appointment();
        System.out.print("Documento del paciente (Long) > ");
        String pd = sc.nextLine().trim();
        if (!pd.isEmpty()) {
            try {
                a.setPatientDocument(Long.valueOf(pd));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Documento del medico tratante (Long) > ");
        String mtd = sc.nextLine().trim();
        if (!mtd.isEmpty()) {
            try {
                a.setAttendingPhysicianDocument(Long.valueOf(pd));
            } catch (NumberFormatException e) {
            }
        }

        return a;
    }
}
