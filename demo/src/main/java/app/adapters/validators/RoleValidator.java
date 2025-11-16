
package app.adapters.validators;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.UserPort;

public class RoleValidator {
    
    private UserPort userPort;
    
    public boolean isValidRole(Long actorDocument, Role rol) throws Exception {
        if(actorDocument == null || actorDocument.toString().trim().isBlank()) {
            return false;
        }
        User u = userPort.findByActorDocument(actorDocument);
        if(u == null) {
            return false;
        }
        Role r = u.getRole();
        return r == rol;
        
    }
}
