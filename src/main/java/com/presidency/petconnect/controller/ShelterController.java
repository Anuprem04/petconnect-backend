
package com.presidency.petconnect.controller;

import com.presidency.petconnect.dto.ShelterDto;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.service.ShelterService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/petConnect/shelters")
public class ShelterController {

    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @PostMapping
    public ResponseEntity<ShelterDto> createShelter(@RequestBody ShelterDto shelterDto) {
        ShelterDto createdShelter = shelterService.createShelter(shelterDto);
        return new ResponseEntity<>(createdShelter, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ShelterDto> getShelterById(@PathVariable int id) throws ResourceNotFoundException {
        ShelterDto shelter = shelterService.getShelterById(id);
        return ResponseEntity.ok(shelter);
    }

    @GetMapping
    public ResponseEntity<List<ShelterDto>> getAllShelters() {
        List<ShelterDto> shelters = shelterService.getAllShelters();
        return ResponseEntity.ok(shelters);
    }

    @PutMapping("{id}")
    public ResponseEntity<ShelterDto> updateShelter(@PathVariable int id, @RequestBody ShelterDto shelterDto) throws ResourceNotFoundException {
        ShelterDto updatedShelter = shelterService.updateShelterById(id, shelterDto);
        return ResponseEntity.ok(updatedShelter);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteShelter(@PathVariable int id) throws ResourceNotFoundException {
        shelterService.deleteShelterById(id);
        return ResponseEntity.ok("Shelter deleted successfully");
    }
}
