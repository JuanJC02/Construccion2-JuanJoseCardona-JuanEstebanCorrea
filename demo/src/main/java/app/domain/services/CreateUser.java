package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;
import app.adapters.validators.SimpleValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {
    
    @Autowired
    private UserPort userPort;
    @Autowired
    private SimpleValidators simpleValidators;

    public void create(User user) throws Exception {
        User us1 = userPort.findByUser(user);
        if (us1.getDocument() != null) {
            throw new Exception("ya existe una persona registrada con esa cedula");
        }
        if (us1.getUsername() != null) {
            throw new Exception("ya existe una persona registrada con ese nombre de usuario");
        }
        if (user.getEmail() != null & !simpleValidators.isValidEmail(user.getEmail())) {
            throw new Exception("correo no valido: no se puede crear el usuario");
        }
        if (user.getPhonenumber() != null & !simpleValidators.isValidTelefono(user.getPhonenumber())) {
            throw new Exception("telefono no valido: no se puede crear el usuario");
        }
        if (user.getBirthdate() != null & !simpleValidators.isValidFechaNacimiento(user.getBirthdate())) {
            throw new Exception("fecha de nacimiento no valida: no se puede crear el usuario");
        }
        if (user.getAddress() != null & !simpleValidators.isLessThan30(user.getAddress())) {
            throw new Exception("direccion con mas de 30 caracteres: no se puede crear el usuario");
        }
        userPort.save(user);
    }
}
