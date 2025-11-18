package app.adapters.in.builders;

import app.domain.model.ProcedureOrder;
import java.util.Scanner;

public class ProcedureOrderBuilder {

    private final Scanner sc = new Scanner(System.in);

    public ProcedureOrder buildFromConsole() {
        ProcedureOrder o = new ProcedureOrder();
        System.out.print("Numero de orden (orderNumber) (Long) > ");
        String on = sc.nextLine().trim();
        if (!on.isEmpty()) {
            try {
                o.setOrderNumber(Long.valueOf(on));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Nombre del procedimiento > ");
        o.setProcedureName(sc.nextLine().trim());
        System.out.print("Numero de repeticion (int) > ");
        String rn = sc.nextLine().trim();
        if (!rn.isEmpty()) {
            try {
                o.setRepetitionNumber(Integer.parseInt(rn));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Frecuencia (int) > ");
        String fr = sc.nextLine().trim();
        if (!fr.isEmpty()) {
            try {
                o.setFrequency(Integer.parseInt(fr));
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
