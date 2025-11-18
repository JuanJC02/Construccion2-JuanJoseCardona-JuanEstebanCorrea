package app.adapters.in.input;

import app.adapters.in.builders.ProcedureOrderBuilder;
import app.domain.model.ProcedureOrder;
import org.springframework.stereotype.Component;

@Component
public class ProcedureOrderInputAdapter {

    private final ProcedureOrderBuilder builder = new ProcedureOrderBuilder();

    public ProcedureOrder buildProcedureOrderFromConsole() {
        return builder.buildFromConsole();
    }

}
