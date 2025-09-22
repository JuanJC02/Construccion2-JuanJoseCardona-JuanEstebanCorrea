package app.domain.usecase;

import app.domain.model.*;
import app.domain.services.*;
import app.domain.model.enums.Role;

public class HumanResourcesUseCase {

    private CreateUser createUser;
    private DeleteUser deleteUser;
    private RolManager rolManager;
    private UserManager userManager;

    public void createHumanResourcesUser(User user, User actor) throws Exception {
        user.setRole(Role.HUMAN_RESOURCES);
        createUser.create(user, actor);
    }

    public void createAdministrativeStaffUser(User user, User actor) throws Exception {
        user.setRole(Role.ADMINISTRATIVE_STAFF);
        createUser.create(user, actor);
    }

    public void createInformationSupportUser(User user, User actor) throws Exception {
        user.setRole(Role.INFORMATION_SUPPORT);
        createUser.create(user, actor);
    }

    public void createNurseUser(User user, User actor) throws Exception {
        user.setRole(Role.NURSE);
        createUser.create(user, actor);
    }

    public void createDoctorUser(User user, User actor) throws Exception {
        user.setRole(Role.DOCTOR);
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
