
package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;

public class DeleteUser {
    private UserPort userPort;
    
    public void delete(User user) throws Exception {
        if (user == null) {
            throw new Exception("no se ha recibido un usuario");
        }
        
        User us = userPort.findByUser(user);
        if(us == null) {
            throw new Exception("no se ha encontrado un usuario similar en la base de datos");
        }
        if (userPort.findByDocument(us.getDocument()) == null) {
            throw new Exception("no existe un usuario registrado con esa cedula");
        }
        userPort.delete(user);
    }
}
