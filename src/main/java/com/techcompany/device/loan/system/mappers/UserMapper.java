package com.techcompany.device.loan.system.mappers;

import com.techcompany.device.loan.system.dto.SignUpDto;
import com.techcompany.device.loan.system.dto.UserDto;
import com.techcompany.device.loan.system.enums.Role;
import com.techcompany.device.loan.system.model.User;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        if (user == null) return null;

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .role(user.getRole())
                .build();
    }

    public static User signUpToUser(SignUpDto dto) {
        if (dto == null) return null;

        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .userName(dto.getUserName())
                .role(Role.USER)
                .build();
    }
}
