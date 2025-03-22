
package com.presidency.petconnect.controller;

import com.presidency.petconnect.dto.LoginRequestDto;
import com.presidency.petconnect.dto.UserDto;
import com.presidency.petconnect.entity.User;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.mapper.UserMapper;
import com.presidency.petconnect.service.LoginService;
import com.presidency.petconnect.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/petConnect/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {
        return new ResponseEntity<>(userService.createUser(dto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> update(@PathVariable int id, @RequestBody UserDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted");
    }
}
