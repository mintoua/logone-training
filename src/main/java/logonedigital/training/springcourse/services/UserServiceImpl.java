package logonedigital.training.springcourse.services;

import jakarta.transaction.Transactional;
import logonedigital.training.springcourse.entities.User;
import logonedigital.training.springcourse.repositories.UserRepository;
import logonedigital.training.springcourse.services.interfaces.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> retrieveAllUsers() {

        List<User> userList =
                (List<User>)
                        userRepository.findAll();

        for (User user : userList) {
            log.info(" User : " + user);
        }
        return userList;
    }

    @Override
    @Transactional
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        userRepository
                .delete(user);
    }

    @Override
    public void deleteUserWithId(Long id) {
        userRepository
                .deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        userRepository
                .save(user);
        return user;
    }

    @Override
    public User retrieveUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        log.info("User :" + user);
        return user;
    }
}
