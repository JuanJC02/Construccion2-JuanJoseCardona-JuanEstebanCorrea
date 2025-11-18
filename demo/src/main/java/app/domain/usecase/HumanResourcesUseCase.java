package app.domain.usecase;

import app.domain.model.*;
import app.domain.services.*;
import app.domain.model.enums.Role;
import static app.domain.model.enums.Role.HUMAN_RESOURCES;
import app.adapters.validators.RoleValidator;

public class HumanResourcesUseCase {

    private CreateUser createUser;
    private DeleteUser deleteUser;
    private RolManager rolManager;
    private UpdateUser userManager;
    private RoleValidator roleValidator;

    private final Role rol = HUMAN_RESOURCES;

    public void createHumanResourcesUser(Long actorDocument, User user) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            user.setRole(Role.HUMAN_RESOURCES);
            createUser.create(user);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createAdministrativeStaffUser(Long actorDocument, User user) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            user.setRole(Role.ADMINISTRATIVE_STAFF);
            createUser.create(user);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createInformationSupportUser(Long actorDocument, User user) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            user.setRole(Role.INFORMATION_SUPPORT);
            createUser.create(user);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createNurseUser(Long actorDocument, User user) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            user.setRole(Role.NURSE);
            createUser.create(user);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void createDoctorUser(Long actorDocument, User user) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            user.setRole(Role.DOCTOR);
            createUser.create(user);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void deleteUser(Long actorDocument, User user) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            deleteUser.delete(user);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void changeRole(Long actorDocument, Long document, Role newRole) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            rolManager.changeRole(document, newRole);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }

    public void updateUser(Long actorDocument, User updatedUser) throws Exception {
        if (roleValidator.isValidRole(actorDocument, rol)) {
            userManager.updateUser(updatedUser);
        } else {
            throw new Exception("no se puede ejecutar la accion por falta de permisos");
        }
    }
}
