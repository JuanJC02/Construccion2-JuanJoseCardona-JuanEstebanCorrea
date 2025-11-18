package app.adapters.in.input;

import app.adapters.in.builders.BillBuilder;
import app.domain.model.Bill;
import org.springframework.stereotype.Component;

@Component
public class BillInputAdapter {

    private final BillBuilder builder = new BillBuilder();

    public Bill buildBillFromConsole() {
        return builder.buildFromConsole();
    }

}
