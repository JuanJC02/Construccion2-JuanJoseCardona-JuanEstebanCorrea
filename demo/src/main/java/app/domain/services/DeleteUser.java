
package app.domain.services;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.UserPort;

public class DeleteUser {
    private UserPort userPort;
    
    public void delete(User user, User actor) throws Exception {
        User actor1 = userPort.findByActor(actor);
        if (actor1 == null) {
            throw new Exception("actor no encontrado: no se puede cambiar el rol");
        }
        if (!actor1.getRole().equals(Role.HUMAN_RESOURCES)) {
            throw new Exception("el actor no tiene Permisos para modificar los roles");
        }
        
        if (userPort.findByUser(user) == null) {
            throw new Exception("no existe un usuario registrado con esa cedula");
        }
        if (userPort.findByUser(user) == null) {
            throw new Exception("no existe un usuario registrado con ese nombre de usuario");
        }
        userPort.delete(user);
    }
}
