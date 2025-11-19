
package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;

public class RoleValidator {
    
    private UserPort userPort;
    
    public boolean Validar(Long documento) throws Exception{
        User s = userPort.findByDocument(documento);
        if(s == null){
            return true;
        } else {
            System.out.println("No se ha encontrado usuario con ese documento: ");
        return false;
        }
    }
}
