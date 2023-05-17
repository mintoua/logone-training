package logonedigital.springcourse.controllers;

import logonedigital.springcourse.dtos.UserDto;
import logonedigital.springcourse.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/users")
public class UserController {

    final UserServiceImpl userService;

    // Build Add User REST API
    // http://localhost:8080/api/v1/users/add
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user){
        UserDto savedUser = userService.addUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Build Get User REST API
    // http://localhost:8080/api/v1/users
    @GetMapping()
	@ResponseBody
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.retrieveAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build GetById User REST API
    // http://localhost:8080/api/v1/users/get/2
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    // Build Update User REST API
    // http://localhost:8080/api/v1/users/update/2
    @PutMapping("/update/{id}")

    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    // http://localhost:8080/api/v1/users/delete/8
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUserWithId(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }


}
