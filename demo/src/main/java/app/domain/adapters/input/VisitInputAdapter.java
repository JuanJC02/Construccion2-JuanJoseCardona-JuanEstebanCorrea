package app.domain.adapters.input;

import app.domain.builders.VisitBuilder;
import app.domain.model.Visit;

public class VisitInputAdapter {
	
	private final VisitBuilder builder = new VisitBuilder();
	
	public Visit BuildVisitFromConsole() {
		return builder.buildFromConsole();
	}

}
