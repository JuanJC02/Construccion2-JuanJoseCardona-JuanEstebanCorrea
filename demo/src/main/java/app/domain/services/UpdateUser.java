package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUser {

    private final UserPort userPort;

    @Autowired
    public UpdateUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void updateUser(User updatedUser) throws Exception {

        if (updatedUser == null || updatedUser.getDocument() == null) {
            throw new Exception("Datos insuficientes para actualizar usuario.");
        }

        User userToUpdate = userPort.findByDocument(updatedUser.getDocument());
        if (userToUpdate == null) {
            throw new Exception("Usuario no encontrado: no se pueden actualizar datos.");
        }

        if (updatedUser.getUsername() != null) {
            userToUpdate.setUsername(updatedUser.getUsername());
        }
        if (updatedUser.getPassword() != null) {
            userToUpdate.setPassword(updatedUser.getPassword());
        }
        if (updatedUser.getName() != null) {
            userToUpdate.setName(updatedUser.getName());
        }
        if (updatedUser.getLastName() != null) {
            userToUpdate.setLastName(updatedUser.getLastName());
        }
        if (updatedUser.getEmail() != null) {
            userToUpdate.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPhonenumber() != null) {
            userToUpdate.setPhonenumber(updatedUser.getPhonenumber());
        }
        if (updatedUser.getAddress() != null) {
            userToUpdate.setAddress(updatedUser.getAddress());
        }
        if (updatedUser.getBirthdate() != null) {
            userToUpdate.setBirthdate(updatedUser.getBirthdate());
        }

        userPort.update(userToUpdate);
    }
}
