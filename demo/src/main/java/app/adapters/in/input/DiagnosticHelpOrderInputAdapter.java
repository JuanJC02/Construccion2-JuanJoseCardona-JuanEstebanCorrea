package app.adapters.in.input;

import app.adapters.in.builders.DiagnosticHelpOrderBuilder;
import app.domain.model.DiagnosticHelpOrder;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticHelpOrderInputAdapter {
    private final DiagnosticHelpOrderBuilder builder = new DiagnosticHelpOrderBuilder();
    
    public DiagnosticHelpOrder buildDiagnosticHelpOrderFromConsole() {
        return builder.buildFromConsole();
    }
}
