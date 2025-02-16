package com.presidency.petconnect.controller;

import com.presidency.petconnect.dto.PetDto;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.service.PetService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pets")
public class PetController {
    private static final Logger PETCONTROLLERLOG = LoggerFactory.getLogger(PetController.class);


    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto petDto) throws ResourceNotFoundException {
        PetDto savedPetDto = petService.createPet(petDto);
        return new ResponseEntity<>(savedPetDto,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PetDto> getPetId(@PathVariable int id) {
        try {
            PetDto petDto = petService.getPetById(id);
            return ResponseEntity.ok(petDto);
        } catch (ResourceNotFoundException e) {
            PETCONTROLLERLOG.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    public ResponseEntity<List<PetDto>> getAllPets() {
            List<PetDto> allPets = petService.getAllPets();
            return ResponseEntity.ok(allPets);
    }
    @PutMapping("{id}")
    public ResponseEntity<PetDto> updatePetById(@PathVariable int id,@RequestBody PetDto petDto) throws ResourceNotFoundException {
        try {
            PetDto updatedPetDto = petService.updatePetById(id,petDto);
            return  ResponseEntity.ok(updatedPetDto);
        }
       catch (ResourceNotFoundException e){
            PETCONTROLLERLOG.error(e.getMessage());
            throw new RuntimeException(e);
       }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        try {
            String response = petService.deletePetById(id);
            return  ResponseEntity.ok(response);
        }
        catch (ResourceNotFoundException e){
            PETCONTROLLERLOG.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
