package app.adapters.in.builders;

import app.adapters.validators.SimpleValidators;
import app.domain.model.Patient;
import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PatientBuilder {

    private final Scanner sc = new Scanner(System.in);
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private SimpleValidators sv;
    private InsurancePort insurancePort;

    public Patient buildFromConsole() {
        Patient p = new Patient();
        //SimpleValidators sv = new SimpleValidators();
        System.out.print("Nombre > ");
        p.setName(sc.nextLine().trim());
        
        System.out.print("Apellido > ");
        p.setLastName(sc.nextLine().trim());
        
        System.out.print("edad (int) > ");
        String ed = sc.nextLine().trim();
        
        if (!ed.isEmpty()) {
            try {
                p.setAge(Integer.parseInt(ed));
            } catch (NumberFormatException e) {
            }
        }
        
        System.out.print("Documento (Long) > ");
        String doc = sc.nextLine().trim();
        
        if (!doc.isEmpty()) {
            try {
                p.setDocument(Long.valueOf(doc));
            } catch (NumberFormatException e) {
            }
        }
        
        System.out.print("Email > ");
        p.setEmail(sc.nextLine().trim());
        
        System.out.print("Telefono > ");
        p.setPhonenumber(sc.nextLine().trim());
        
        System.out.print("Direccion > ");
        String addr = sc.nextLine().trim();
        if (!sv.isValidAddress(addr)) {
            throw new IllegalArgumentException("direccion invalida: maximo 30 caracteres");
        }
        p.setAddress(addr);
        
        System.out.print("Genero (single char M/F/O) > ");
        String g = sc.nextLine().trim();
        if (!g.isEmpty()) {
            p.setGender(g.charAt(0));
        }
        
        System.out.print("Fecha de nacimiento (dd/MM/yyyy) > ");
        String d = sc.nextLine().trim();
        if (!d.isEmpty()) {
            try {
                java.time.LocalDate bd = LocalDate.parse(d, fmt);
                if (!sv.isValidBirthDate(bd)) {
                    throw new IllegalArgumentException("fecha de nacimiento invalida");
                }
                p.setBirthDate(bd);
            } catch (DateTimeParseException e) {
            }
        }
        
        System.out.print("Usuario (username) > ");
        String username = sc.nextLine().trim();
        if (!sv.isValidUsername(username)) {
            throw new IllegalArgumentException("username invalido: debe ser alfanumerico maximo 15 caracteres");
        }
        p.setUsername(username);
        
        System.out.print("Contrasena (password) > ");
        String password = sc.nextLine().trim();
        if (!sv.isValidPassword(password)) {
            throw new IllegalArgumentException("password invalida: minimo 8 caracteres, 1 mayuscula, 1 numero y 1 caracter especial");
        }
        p.setPassword(password);

        return p;
    }
}
