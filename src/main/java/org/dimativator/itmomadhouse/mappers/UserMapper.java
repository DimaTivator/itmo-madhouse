package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.RegisteredUserDto;
import org.dimativator.itmomadhouse.dto.SignUpDto;
import org.dimativator.itmomadhouse.dto.UserDto;
import org.dimativator.itmomadhouse.model.User;

public class UserMapper {
    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        return User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .build();
    }

    public static User toEntity(SignUpDto signUpDto) {
        return User.builder()
                .login(signUpDto.getLogin())
                .role(signUpDto.getRole())
                .build();
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }

    public static RegisteredUserDto toRegisteredUserDto(User user) {
        // token is set in UserServiceImpl
        return RegisteredUserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .role(user.getRole())
                .build();
    }
} 