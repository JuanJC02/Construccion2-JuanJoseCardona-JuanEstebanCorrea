package app.adapters.in.input;

import app.adapters.in.builders.InsuranceBuilder;
import app.domain.model.Insurance;

public class insuranceInputAdapter {

    private final InsuranceBuilder builder = new InsuranceBuilder();

    public Insurance buildInsuranceFromConsole() {
        return builder.buildFromConsole();
    }

}
