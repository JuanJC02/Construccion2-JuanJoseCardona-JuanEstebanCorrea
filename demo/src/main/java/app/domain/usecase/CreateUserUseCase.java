package app.domain.usecase;

import app.domain.model.User;
import app.domain.services.CreateUser;

public class CreateUserUseCase {

    private CreateUser createUser;

    public void execute(User user, User actor) throws Exception {
        createUser.create(user, actor);
    }

}
