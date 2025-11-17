
package app.infrastructure.mapper;

import app.domain.model.User;
import app.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setName(user.getName());
        entity.setLastName(user.getLastName());
        entity.setDocument(user.getDocument());
        entity.setEmail(user.getEmail());
        entity.setPhonenumber(user.getPhonenumber());
        entity.setBirthdate(user.getBirthdate());
        entity.setAddress(user.getAddress());
        entity.setRole(user.getRole());
        return entity;
    }

    public User toDomain(UserEntity entity) {
        User user = new User();
        user.setUsername(entity.getUsername());
        user.setPassword(entity.getPassword());
        user.setName(entity.getName());
        user.setLastName(entity.getLastName());
        user.setDocument(entity.getDocument());
        user.setEmail(entity.getEmail());
        user.setPhonenumber(entity.getPhonenumber());
        user.setBirthdate(entity.getBirthdate());
        user.setAddress(entity.getAddress());
        user.setRole(entity.getRole());
        return user;
    }
}
