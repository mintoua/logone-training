package logonedigital.springcourse.services.interfaces;

import logonedigital.springcourse.dtos.UserDto;

import java.util.List;

public interface IUserService {
    List <UserDto> retrieveAllUsers();
    UserDto addUser(UserDto user);
    void deleteUserWithId(Long id);
    UserDto updateUser(UserDto user);
    UserDto getUserById(Long id);
}
