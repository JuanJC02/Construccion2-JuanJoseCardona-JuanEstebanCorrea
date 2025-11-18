package app.adapters.in.builders;

import app.domain.model.User;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserBuilder {

    private final Scanner sc = new Scanner(System.in);
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public User buildFromConsole() {
        User u = new User();
        System.out.print("Nombre de Usuario (username) > ");
        u.setUsername(sc.nextLine().trim());

        System.out.print("Contrasena (password) > ");
        u.setPassword(sc.nextLine().trim());

        System.out.print("Nombre > ");
        u.setName(sc.nextLine().trim());

        System.out.print("Apellido > ");
        u.setName(sc.nextLine().trim());

        System.out.print("Documento (Long) > ");
        String doc = sc.nextLine().trim();
        if (!doc.isEmpty()) {
            try {
                u.setDocument(Long.valueOf(doc));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Email > ");
        u.setEmail(sc.nextLine().trim());

        System.out.print("Telefono > ");
        u.setPhonenumber(sc.nextLine().trim());

        System.out.print("Direccion > ");
        u.setAddress(sc.nextLine().trim());

        System.out.print("Fecha de nacimiento (dd/MM/yyyy) > ");
        String d = sc.nextLine().trim();

        if (!d.isEmpty()) {
            try {
                u.setBirthdate(LocalDate.parse(d, fmt));
            } catch (DateTimeParseException e) {
            }
        }

        return u;
    }
}
