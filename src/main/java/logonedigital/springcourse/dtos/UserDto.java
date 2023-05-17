package logonedigital.springcourse.dtos;

import logonedigital.springcourse.entities.User;
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

    public static UserDto fromEntity(User user){

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


    public static User toEntity(UserDto userDto){

        if(userDto == null){
            // TODO Throw an exception
            return null;
        }

        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .enabled(userDto.isEnabled())
                .build();
    }


}
