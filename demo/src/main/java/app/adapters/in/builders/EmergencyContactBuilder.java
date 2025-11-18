package app.adapters.in.builders;

import app.adapters.validators.SimpleValidators;
import app.domain.model.EmergencyContact;
import java.util.Scanner;

public class EmergencyContactBuilder {

    private final Scanner sc = new Scanner(System.in);

    public EmergencyContact buildFromConsole() {
        EmergencyContact e = new EmergencyContact();
        SimpleValidators sv = new SimpleValidators();
        System.out.print("Nombre contacto > ");
        e.setName(sc.nextLine().trim());

        System.out.print("Apellido contacto > ");
        e.setLastName(sc.nextLine().trim());

        System.out.print("Relacion > ");
        e.setRelation(sc.nextLine().trim());

        System.out.print("Telefono contacto > ");
        String phone = sc.nextLine().trim();
        if (!sv.isValidPhone(phone)) {
            throw new IllegalArgumentException("telefono contacto invalido: debe tener 10 digitos");
        }
        e.setPhoneNumber(phone);

        System.out.print("Documento de paciente (Long) > ");
        String pd = sc.nextLine().trim();
        if (!pd.isEmpty()) {
            try {
                e.setPatientDocument(Long.valueOf(pd));
            } catch (NumberFormatException a) {
            }
        }
        return e;
    }
}
