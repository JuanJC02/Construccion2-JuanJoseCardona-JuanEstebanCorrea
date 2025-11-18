package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;
import app.domain.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolManager {

    @Autowired
    private UserPort userPort;

    public void changeRole(Long document, Role newRole) throws Exception {

        if (document == null || newRole == null) {
            throw new Exception("Datos insuficientes para cambiar rol.");
        }

        User user = userPort.findByDocument(document);

        if (user == null) {
            throw new Exception("No existe usuario con el documento ingresado.");
        }

        user.setRole(newRole);
        userPort.save(user);
    }
}