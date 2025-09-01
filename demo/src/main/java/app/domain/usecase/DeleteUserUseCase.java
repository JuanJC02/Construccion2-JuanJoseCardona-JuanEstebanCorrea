package app.domain.usecase;

import app.domain.model.User;
import app.domain.services.DeleteUser;

public class DeleteUserUseCase {

    private DeleteUser deleteUser;

    public void execute(User user, User actor) throws Exception {
        deleteUser.delete(user, actor);
    }

}
