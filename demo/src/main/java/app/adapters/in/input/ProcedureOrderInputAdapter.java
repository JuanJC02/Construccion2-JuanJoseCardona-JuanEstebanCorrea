package app.adapters.in.input;

import app.adapters.in.builders.ProcedureOrderBuilder;
import app.domain.model.ProcedureOrder;


public class ProcedureOrderInputAdapter {
	
	private final ProcedureOrderBuilder builder = new ProcedureOrderBuilder();
	
	public ProcedureOrder buildProcedureOrderFromConsole() {
		return builder.buildFromConsole();
	}

}
