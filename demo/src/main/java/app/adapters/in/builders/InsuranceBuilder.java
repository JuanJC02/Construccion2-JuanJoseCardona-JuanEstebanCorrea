package app.adapters.in.builders;

import app.domain.model.Insurance;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InsuranceBuilder {

    private final Scanner sc = new Scanner(System.in);
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Insurance buildFromConsole() {
        Insurance i = new Insurance();
        System.out.print("Nombre de la compania > ");
        i.setCompanyName(sc.nextLine().trim());
        
        System.out.print("Numero de poliza (Long) > ");
        String pn = sc.nextLine().trim();
        if (!pn.isEmpty()) {
            try {
                i.setPolicyNumber(Long.valueOf(pn));
            } catch (NumberFormatException e) {
            }
        }
        
        System.out.print("Estado de la poliza (true/false) > ");
        String st = sc.nextLine().trim();
        if (!st.isEmpty()) {
            i.setPolicyStatus(Boolean.parseBoolean(st));
        }
        
        System.out.print("Fecha de expiracion (dd/MM/yyyy) > ");
        String d = sc.nextLine().trim();
        if (!d.isEmpty()) {
            try {
                i.setPolicyExpirationDate(LocalDate.parse(d, fmt));
            } catch (DateTimeParseException e) {
            }
        }
        
        System.out.print("Documento de paciente (Long) > ");
        String pd = sc.nextLine().trim();
        if (!pd.isEmpty()) {
            try {
                i.setPatientDocument(Long.valueOf(pd));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }
}
