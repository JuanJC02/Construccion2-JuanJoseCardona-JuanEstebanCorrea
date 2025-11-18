package app.adapters.in.builders;

import app.domain.model.DiagnosticHelpOrder;
import java.util.Scanner;

public class DiagnosticHelpOrderBuilder {

    private final Scanner sc = new Scanner(System.in);

    public DiagnosticHelpOrder buildFromConsole() {
        DiagnosticHelpOrder o = new DiagnosticHelpOrder();
        System.out.print("Documento de el paciente (Long) > ");
        String pd = sc.nextLine().trim();
        if (!pd.isEmpty()) {
            try {
                o.setPatientDocument(Long.valueOf(pd));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Numero de item (int) > ");
        String it = sc.nextLine().trim();
        if (!it.isEmpty()) {
            try {
                o.setItemNumber(Integer.parseInt(it));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Nombre del examen > ");
        o.setExamName(sc.nextLine().trim());
        System.out.print("Cantidad (int) > ");
        String amt = sc.nextLine().trim();
        if (!amt.isEmpty()) {
            try {
                o.setAmount(Integer.parseInt(amt));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Costo (int) > ");
        String cost = sc.nextLine().trim();
        if (!cost.isEmpty()) {
            try {
                o.setCost(Integer.parseInt(cost));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Requiere especialista? (true/false) > ");
        String rs = sc.nextLine().trim();
        if (!rs.isEmpty()) {
            o.setRequiresSpecialist(Boolean.parseBoolean(rs));
        }

        System.out.print("Especialidad Id (Long) [opcional] > ");
        String sid = sc.nextLine().trim();
        if (!sid.isEmpty()) {
            try {
                o.setSpecialtytId(Long.valueOf(sid));
            } catch (NumberFormatException e) {
            }
        }
        return o;
    }
}
