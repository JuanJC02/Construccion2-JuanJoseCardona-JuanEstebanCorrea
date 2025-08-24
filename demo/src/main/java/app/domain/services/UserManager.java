package app.domain.services;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.UserPort;

public class UserManager {

    private UserPort userPort;

    public void updateUser(User updatedUser, User actor) throws Exception {
        User actor1 = userPort.findByActor(actor);
        if (actor1 == null) {
            throw new Exception("actor no encontrado: no se puede cambiar el rol");
        }
        if (!actor1.getRole().equals(Role.HUMAN_RESOURCES)) {
            throw new Exception("el actor no tiene Permisos para modificar los roles");
        }

        User userToUpdate = userPort.findByUser(updatedUser);
        if (userToUpdate == null) {
            throw new Exception("usuario no encontrado: no se pueden actualizar datos");
        }

        if (updatedUser.getUserName() != null) {
            userToUpdate.setUserName(updatedUser.getUserName());
        }
        if (updatedUser.getName() != null) {
            userToUpdate.setName(updatedUser.getName());
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
        userPort.save(userToUpdate);
    }
}
