package app.adapters.in.builders;

import app.domain.model.MedicamentOrder;
import java.util.Scanner;

public class MedicamentOrderBuilder {

    private final Scanner sc = new Scanner(System.in);

    public MedicamentOrder buildFromConsole() {
        MedicamentOrder o = new MedicamentOrder();
        System.out.print("Numero de item (int) > ");
        String it = sc.nextLine().trim();
        if (!it.isEmpty()) {
            try {
                o.setItemNumber(Integer.parseInt(it));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Nombre del medicamento > ");
        o.setMedicamentName(sc.nextLine().trim());

        System.out.print("Dosis > ");
        o.setDose(sc.nextLine().trim());

        System.out.print("Duracion del tratamiento > ");
        o.setTreatmentDuration(sc.nextLine().trim());

        System.out.print("documento de el paciente (Long) > ");
        String pd = sc.nextLine().trim();
        if (!pd.isEmpty()) {
            try {
                o.setPatientDocument(Long.valueOf(pd));
            } catch (NumberFormatException e) {
            }
        }
        return o;
    }
}
