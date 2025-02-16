
package com.presidency.petconnect.controller;

import com.presidency.petconnect.dto.AccessoryDto;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.service.AccessoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accessories")
public class AccessoryController {

    private final AccessoryService service;

    public AccessoryController(AccessoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AccessoryDto> create(@RequestBody AccessoryDto dto) {
        return new ResponseEntity<>(service.createAccessory(dto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AccessoryDto> getById(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.getAccessoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<AccessoryDto>> getAll() {
        return ResponseEntity.ok(service.getAllAccessories());
    }

    @PutMapping("{id}")
    public ResponseEntity<AccessoryDto> update(@PathVariable int id, @RequestBody AccessoryDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateAccessory(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException {
        service.deleteAccessory(id);
        return ResponseEntity.ok("Accessory deleted");
    }
}
