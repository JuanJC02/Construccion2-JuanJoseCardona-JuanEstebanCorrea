package app.domain.adapters.input;

import app.domain.builders.MedicamentOrderBuilder;
import app.domain.model.MedicamentOrder;


public class MedicamenOrderInputAdapter {
	
	private final MedicamentOrderBuilder builder =  new MedicamentOrderBuilder();
	
	public MedicamentOrder buildMedicalOrderFromConsole() {
		return builder.buildFromConsole();
	}

}
