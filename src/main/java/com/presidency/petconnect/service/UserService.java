
package com.presidency.petconnect.service;

import com.presidency.petconnect.dto.UserDto;
import com.presidency.petconnect.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(int id) throws ResourceNotFoundException;
    List<UserDto> getAllUsers();
    UserDto updateUser(int id, UserDto userDto) throws ResourceNotFoundException;
    void deleteUser(int id) throws ResourceNotFoundException;
}
