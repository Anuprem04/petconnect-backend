
package com.presidency.petconnect.controller;

import com.presidency.petconnect.dto.AdoptionDto;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.service.AdoptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/petConnect/adoptions")
public class AdoptionController {

    private final AdoptionService service;

    public AdoptionController(AdoptionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AdoptionDto> create(@RequestBody AdoptionDto dto) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.createAdoption(dto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AdoptionDto> getById(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.getAdoptionById(id));
    }

    @GetMapping
    public ResponseEntity<List<AdoptionDto>> getAll() {
        return ResponseEntity.ok(service.getAllAdoptions());
    }

    @PutMapping("{id}")
    public ResponseEntity<AdoptionDto> update(@PathVariable int id, @RequestBody AdoptionDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateAdoption(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException {
        service.deleteAdoption(id);
        return ResponseEntity.ok("Adoption deleted");
    }
}
