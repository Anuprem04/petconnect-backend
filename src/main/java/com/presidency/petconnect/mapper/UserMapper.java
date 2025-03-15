
package com.presidency.petconnect.mapper;

import com.presidency.petconnect.dto.UserDto;
import com.presidency.petconnect.entity.User;

public class UserMapper {
    public static UserDto toDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPetPreferences(),
                user.getPhone(),
                user.getAddress(),
                user.getCreatedAt()
        );
    }

    public static User toEntity(UserDto dto) {
        return new User(
                dto.getUserId(),
                dto.getName(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getPetPreferences(),
                dto.getPhone(),
                dto.getCity()
        );
    }
}
