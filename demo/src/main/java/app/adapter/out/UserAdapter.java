package app.adapter.out;

import app.domain.model.User;
import app.domain.ports.UserPort;
import app.infrastructure.entity.UserEntity;
import app.infrastructure.mapper.UserMapper;
import app.infrastructure.repository.jpa.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class UserAdapter implements UserPort {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Autowired
    public UserAdapter(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User findByDocument(Long document) throws Exception {
        Optional<UserEntity> opt = repository.findAll()
                .stream()
                .filter(u -> document.equals(u.getDocument()))
                .findFirst();

        if (opt.isEmpty()) {
            return null;
        }

        return mapper.toModel(opt.get());
    }

    @Override
    public User findByUserName(String username) throws Exception {
        Optional<UserEntity> opt = repository.findAll()
                .stream()
                .filter(u -> username.equals(u.getUsername()))
                .findFirst();

        if (opt.isEmpty()) {
            return null;
        }

        return mapper.toModel(opt.get());
    }

    @Override
    public User findByUser(User user) throws Exception {
        return findByUserName(user.getUsername());
    }

    @Override
    public User findByActorDocument(Long document) throws Exception {
        return findByDocument(document);
    }

    @Override
    public User findDoctorByDocument(Long treatingPhysicianDocument) throws Exception {
        User user = findByDocument(treatingPhysicianDocument);

        if (user == null) {
            return null;
        }

        if (!user.getRole().name().equals("DOCTOR")) {
            throw new Exception("El usuario no es un doctor");
        }

        return user;
    }

    @Override
    public void save(User user) throws Exception {
        UserEntity entity = mapper.toEntity(user);
        repository.save(entity);
    }

    @Override
    public void update(User user) throws Exception {
        if (user.getId() == null) {
            throw new Exception("No se puede actualizar un usuario sin ID");
        }

        UserEntity entity = mapper.toEntity(user);
        repository.save(entity);
    }

    @Override
    public void delete(User user) throws Exception {
        if (user.getId() == null) {
            throw new Exception("No se puede eliminar un usuario sin ID");
        }

        repository.deleteById(user.getId());
    }

    @Override
    public void setRole(User user) throws Exception {
        UserEntity entity = repository.findAll()
                .stream()
                .filter(u -> user.getDocument().equals(u.getDocument()))
                .findFirst()
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        entity.setRole(user.getRole());
        repository.save(entity);
    }
}
