package app.domain.adapters.input;

import app.domain.builders.UserBuilder;
import app.domain.model.User;

public class UserInputAdapter {
	
	private final UserBuilder builder = new UserBuilder();
	
	public User buildUserFromConsole() {
		return builder.buildFromConsole();
	}

}
