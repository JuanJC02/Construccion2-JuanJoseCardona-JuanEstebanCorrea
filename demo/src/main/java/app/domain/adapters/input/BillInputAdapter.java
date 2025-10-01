package app.domain.adapters.input;

import app.domain.builders.BillBuilder;
import app.domain.model.Bill;

public class BillInputAdapter {
	
	private final BillBuilder builder = new BillBuilder();
	
	public Bill buildBillFromConsole() {
		return builder.buildFromConsole();
	}

}
