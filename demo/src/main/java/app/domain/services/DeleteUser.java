package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUser {
    @Autowired
    private UserPort userPort;

    public void delete(User user) throws Exception {
        if (user == null) {
            throw new Exception("no se ha recibido un usuario");
        }
        userPort.delete(user);
    }
}
