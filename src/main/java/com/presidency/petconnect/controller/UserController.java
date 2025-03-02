
package com.presidency.petconnect.controller;

import com.presidency.petconnect.dto.UserDto;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/petConnect/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {
        return new ResponseEntity<>(service.createUser(dto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> update(@PathVariable int id, @RequestBody UserDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateUser(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException {
        service.deleteUser(id);
        return ResponseEntity.ok("User deleted");
    }
}
