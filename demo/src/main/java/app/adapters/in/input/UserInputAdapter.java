package app.adapters.in.input;

import app.adapters.in.builders.UserBuilder;
import app.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserInputAdapter {

    private final UserBuilder builder = new UserBuilder();

    public User buildUserFromConsole() {
        return builder.buildFromConsole();
    }

}
