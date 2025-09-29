package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;
import app.domain.model.enums.Role;

public class RolManager {

    private UserPort userPort;

    public void changeRole(Role newRole, User user) throws Exception {
        
        if (user == null || newRole == null) {
            throw new Exception("no se puede realizar la accion por falta de datos");
        }
        
        if (userPort.findByUser(user).getDocument() == null || userPort.findByUser(user).getUsername() == null) {
            throw new Exception("no existe usuario igual a el usuario recibido");
        }
        
        user.setRole(newRole);
        userPort.save(user);
    }
}
