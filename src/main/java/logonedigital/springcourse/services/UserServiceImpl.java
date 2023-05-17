package logonedigital.springcourse.services;

import jakarta.transaction.Transactional;
import logonedigital.springcourse.dtos.UserDto;
import logonedigital.springcourse.entities.User;
import logonedigital.springcourse.repositories.UserRepository;
import logonedigital.springcourse.services.interfaces.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    final UserRepository userRepository;

    @Override
    @Transactional
    public UserDto addUser(UserDto userDto) {
        // TODO Handling Exception Here before
        return UserDto.fromEntity(UserDto.toEntity(userDto));
    }

    @Override
    public List<UserDto> retrieveAllUsers() {

        List<User> userList = userRepository.findAll();

        for (User user : userList) {
            log.info(" User : " + user);
        }

        return userList.stream().map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUserWithId(Long id) {
        // TODO Handling Exception Here before

        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(UserDto user) {

        // TODO Handling Exception Here before

        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);

        return UserDto.fromEntity(updatedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        log.info("User :" + user);
        return UserDto.fromEntity(user);
    }
}
