package app.adapters.in.builders;

import app.domain.model.ClinicalHistory;
import java.util.Scanner;

public class ClinicalHistoryBuilder {

    private final Scanner sc = new Scanner(System.in);

    public ClinicalHistory buildFromConsole() {
        ClinicalHistory h = new ClinicalHistory();
        System.out.print("Fecha (dd/MM/yyyy) > ");
        h.setDate(sc.nextLine().trim());

        System.out.print("Documento del paciente (Long) > ");
        String d = sc.nextLine().trim();
        if (!d.isEmpty()) {
            try {
                h.setPatientDocument(Long.valueOf(d));
            } catch (NumberFormatException e) {
            }
        }

        System.out.print("Documento del doctor (Long) > ");
        String dd = sc.nextLine().trim();
        if (!dd.isEmpty()) {
            try {
                h.setDoctorId(Long.valueOf(d));
            } catch (NumberFormatException e) {
            }
        }
        System.out.print("Motivo de la consulta > ");
        h.setReasonForConsultation(sc.nextLine().trim());

        System.out.print("Sintomas > ");
        h.setSymptoms(sc.nextLine().trim());

        System.out.print("Diagnostico > ");
        h.setDiagnosis(sc.nextLine().trim());

        return h;
    }
}
