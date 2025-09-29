package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;

public class UpdateUser {

    private UserPort userPort;

    public void updateUser(User updatedUser) throws Exception {
        
        if (updatedUser == null) {
            throw new Exception("no se puede realizar la accion por falta de datos");
        }

        User userToUpdate = userPort.findByDocument(updatedUser.getDocument());
        if (userToUpdate == null) {
            throw new Exception("usuario no encontrado: no se pueden actualizar datos");
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
        userPort.update(userToUpdate);
    }
}
