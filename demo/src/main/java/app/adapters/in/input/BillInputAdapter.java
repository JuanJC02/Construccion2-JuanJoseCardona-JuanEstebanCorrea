package app.adapters.in.input;

import app.adapters.in.builders.BillBuilder;
import app.domain.model.Bill;

public class BillInputAdapter {
	
	private final BillBuilder builder = new BillBuilder();
	
	public Bill buildBillFromConsole() {
		return builder.buildFromConsole();
	}

}
