package app.adapters.in.input;

import app.adapters.in.builders.VisitBuilder;
import app.domain.model.Visit;
import org.springframework.stereotype.Component;

@Component
public class VisitInputAdapter {

    private final VisitBuilder builder = new VisitBuilder();

    public Visit BuildVisitFromConsole() {
        return builder.buildFromConsole();
    }

}
