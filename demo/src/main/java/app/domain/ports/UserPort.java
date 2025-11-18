package app.domain.ports;

import app.domain.model.User;

public interface UserPort {

    public User findByDocument(Long document) throws Exception;

    public User findByUserName(String username) throws Exception;

    public User findByUser(User user) throws Exception;

    public User findByActorDocument(Long document) throws Exception;

    public User findDoctorByDocument(Long treatingPhysicianDocument) throws Exception;

    public void save(User user) throws Exception;

    public void update(User user) throws Exception;

    public void delete(User user) throws Exception;

    public void setRole(User user) throws Exception;
}
