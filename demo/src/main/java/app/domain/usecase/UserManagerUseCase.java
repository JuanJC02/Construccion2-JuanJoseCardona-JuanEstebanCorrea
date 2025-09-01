package app.domain.usecase;

import app.domain.model.User;
import app.domain.services.UserManager;

public class UserManagerUseCase {

    private UserManager userManager;

    public void execute(User updatedUser, User actor) throws Exception {
        userManager.updateUser(updatedUser, actor);
    }

}
