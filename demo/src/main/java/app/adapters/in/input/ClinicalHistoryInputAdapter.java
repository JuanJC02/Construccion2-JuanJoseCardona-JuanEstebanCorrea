package app.adapters.in.input;
import app.adapters.in.builders.ClinicalHistoryBuilder;
import app.domain.model.ClinicalHistory;

public class ClinicalHistoryInputAdapter {
	
	private final ClinicalHistoryBuilder builder = new ClinicalHistoryBuilder();
	
	public ClinicalHistory buildFromConsole() {
		return builder.buildFromConsole();
	}

}
