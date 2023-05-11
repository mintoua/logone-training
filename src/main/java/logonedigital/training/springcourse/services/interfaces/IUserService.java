package logonedigital.training.springcourse.services.interfaces;

import logonedigital.training.springcourse.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IUserService {
    List <User> retrieveAllUsers();
    User addUser(User user);
    void deleteUser(User user);
    void deleteUserWithId(Long id);
    User updateUser(User user);
    User retrieveUser(Long id);
}
