
package app.domain.services;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.UserPort;

public class CreateUser {
    private UserPort userPort;
    
    public void create(User user, User actor) throws Exception {
        dd
        User us1 = userPort.findByUser(user);
        if (us1.getDocument() != null) {
            throw new Exception("ya existe una persona registrada con esa cedula");
        }
        if (us1.getUserName() != null) {
            throw new Exception("ya existe una persona registrada con ese nombre de usuario");
        }
        userPort.save(user);
    }
}
