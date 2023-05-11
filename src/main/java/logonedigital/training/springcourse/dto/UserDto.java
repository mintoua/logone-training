package logonedigital.training.springcourse.dto;

import jakarta.persistence.Column;
import logonedigital.training.springcourse.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;
    private String username;
    private String email;
    // TODO Put this attribut with @JsonIgnore
    private boolean enabled;

    public UserDto fromEntity(User user){

        if(user == null){
            // TODO Throw an exception
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .enabled(user.isEnabled())
                .build();
    }


    public User toEntity(UserDto userDto){

        if(userDto == null){
            // TODO Throw an exception
            return null;
        }

        return User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .enabled(userDto.isEnabled())
                .build();
    }


}
