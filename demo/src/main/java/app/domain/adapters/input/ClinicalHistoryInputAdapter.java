package app.domain.adapters.input;

import app.domain.builders.ClinicalHistoryBuilder;
import app.domain.model.ClinicalHistory;

public class ClinicalHistoryInputAdapter {
	
	private final ClinicalHistoryBuilder builder = new ClinicalHistoryBuilder();
	
	public ClinicalHistory buildFromConsole() {
		return builder.buildFromConsole();
	}

}
