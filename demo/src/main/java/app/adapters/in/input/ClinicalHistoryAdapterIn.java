package app.adapters.in.input;

import app.adapters.in.builders.ClinicalHistoryBuilder;
import app.domain.model.ClinicalHistory;
import org.springframework.stereotype.Component;

@Component
public class ClinicalHistoryAdapterIn {

    private final ClinicalHistoryBuilder builder = new ClinicalHistoryBuilder();

    public ClinicalHistory buildHistoryFromConsole() {
        return builder.buildFromConsole();
    }

}
