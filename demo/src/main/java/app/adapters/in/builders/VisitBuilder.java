package app.adapters.in.builders;

import app.domain.model.Visit;
import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VisitBuilder {

    private final Scanner sc = new Scanner(System.in);
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Visit buildFromConsole() {
        Visit v = new Visit();
        System.out.print("Documento de paciente a visitar (Long) > ");
        String pd = sc.nextLine().trim();
        if (!pd.isEmpty()) {
            try {
                v.setPatientToVisitDocument(Long.valueOf(pd));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Fecha de la visita (dd/MM/yyyy) > ");
        String d = sc.nextLine().trim();
        if (!d.isEmpty()) {
            try {
                LocalDate ld = LocalDate.parse(d, fmt);
                v.setVisitDate(Date.valueOf(ld));
            } catch (Exception e) {
            }
        }

        System.out.print("Presion sanguinea (double) > ");
        String bp = sc.nextLine().trim();
        if (!bp.isEmpty()) {
            try {
                v.setBloodPressure(Double.valueOf(bp));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Temperatura (double) > ");
        String t = sc.nextLine().trim();
        if (!t.isEmpty()) {
            try {
                v.setTemperature(Double.valueOf(t));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Frecuencia cardiaca (double) > ");
        String hr = sc.nextLine().trim();
        if (!hr.isEmpty()) {
            try {
                v.setHeartRate(Double.valueOf(hr));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Nivel de oxigeno en sangre (double) > ");
        String ox = sc.nextLine().trim();
        if (!ox.isEmpty()) {
            try {
                v.setBloodOxigenLevel(Double.valueOf(ox));
            } catch (NumberFormatException e) {
            }
        }

        return v;
    }
}
