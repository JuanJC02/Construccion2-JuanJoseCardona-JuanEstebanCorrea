package app.domain.usecase;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.services.RolManager;

public class RolManagerUseCase {

    private RolManager rolManager;

    public void execute(Role newRole, User user, User actor) throws Exception {
        rolManager.changeRole(newRole, user, actor);
    }

}
