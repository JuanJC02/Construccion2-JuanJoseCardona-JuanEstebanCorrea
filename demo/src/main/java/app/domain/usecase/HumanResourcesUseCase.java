package app.domain.usecase;

import app.domain.model.*;
import app.domain.services.*;
import app.domain.model.enums.Role;

public class HumanResourcesUseCase {

    private CreateUser createUser;
    private DeleteUser deleteUser;
    private RolManager rolManager;
    private UserManager userManager;

    public void createUser(User user, User actor) throws Exception {
        createUser.create(user, actor);
    }

    public void deleteUser(User user, User actor) throws Exception {
        deleteUser.delete(user, actor);
    }

    public void changeRole(Role newRole, User user, User actor) throws Exception {
        rolManager.changeRole(newRole, user, actor);
    }

    public void updateUser(User updatedUser, User actor) throws Exception {
        userManager.updateUser(updatedUser, actor);
    }
}
