package app.infrastructure.mapper;

import app.domain.model.User;
import app.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(User model) {
        if (model == null) return null;

        UserEntity entity = new UserEntity();

        entity.setId(model.getId());
        entity.setUsername(model.getUsername());
        entity.setPassword(model.getPassword());
        entity.setName(model.getName());
        entity.setLastName(model.getLastName());
        entity.setDocument(model.getDocument());
        entity.setEmail(model.getEmail());
        entity.setPhonenumber(model.getPhonenumber());
        entity.setBirthdate(model.getBirthdate());
        entity.setAddress(model.getAddress());
        entity.setRole(model.getRole());

        return entity;
    }

    public User toModel(UserEntity entity) {
        if (entity == null) return null;

        User model = new User();

        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setPassword(entity.getPassword());
        model.setName(entity.getName());
        model.setLastName(entity.getLastName());
        model.setDocument(entity.getDocument());
        model.setEmail(entity.getEmail());
        model.setPhonenumber(entity.getPhonenumber());
        model.setBirthdate(entity.getBirthdate());
        model.setAddress(entity.getAddress());
        model.setRole(entity.getRole());

        return model;
    }
}
