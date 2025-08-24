package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;
import app.domain.model.enums.Role;

public class RolManager {

    private UserPort userPort;

    public void changeRole(Role newRole, User user, User actor) throws Exception {
        User actor1 = userPort.findByActor(actor);
        if (actor1 == null) {
            throw new Exception("actor no encontrado: no se puede cambiar el rol");
        }
        if (!actor1.getRole().equals(Role.HUMAN_RESOURCES)) {
            throw new Exception("el actor no tiene Permisos para modificar los roles");
        }
        
        if (userPort.findByUser(user).getDocument() == null) {
            throw new Exception("no existe usuario con ese documento");
        }
        if (userPort.findByUser(user).getUserName() == null) {
            throw new Exception("no existe usuario con ese nombre de usuario");
        }
        
        user.setRole(newRole);
        userPort.save(user);
    }
}
