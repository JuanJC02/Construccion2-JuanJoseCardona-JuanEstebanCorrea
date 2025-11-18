package app.adapters.in.builders;

import app.domain.model.Bill;
import java.util.Scanner;

public class BillBuilder {

    private final Scanner sc = new Scanner(System.in);

    public Bill buildFromConsole() {
        Bill b = new Bill();
        System.out.print("Documento del paciente (Long) > ");
        String pd = sc.nextLine().trim();
        if (!pd.isEmpty()) {
            try {
                b.setPatientDocument(Long.valueOf(pd));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Numero de poliza (Long) [opcional] > ");
        String pn = sc.nextLine().trim();
        if (!pn.isEmpty()) {
            try {
                b.setPolicyNumber(Long.valueOf(pn));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Documento del medico tratante (Long) > ");
        String mtd = sc.nextLine().trim();
        if (!mtd.isEmpty()) {
            try {
                b.setTreatingPhysicianDocument(Long.valueOf(pd));
            } catch (NumberFormatException e) {
            }
        }

        return b;
    }
}
