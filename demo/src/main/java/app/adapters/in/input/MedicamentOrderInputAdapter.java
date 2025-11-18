package app.adapters.in.input;

import app.adapters.in.builders.MedicamentOrderBuilder;
import app.domain.model.MedicamentOrder;
import org.springframework.stereotype.Component;

@Component
public class MedicamentOrderInputAdapter {

    private final MedicamentOrderBuilder builder = new MedicamentOrderBuilder();

    public MedicamentOrder buildMedicalOrderFromConsole() {
        return builder.buildFromConsole();
    }
}
