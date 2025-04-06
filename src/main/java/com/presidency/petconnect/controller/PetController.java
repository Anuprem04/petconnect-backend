package com.presidency.petconnect.controller;

import com.presidency.petconnect.dto.PetDto;
import com.presidency.petconnect.dto.PetRequestDto;
import com.presidency.petconnect.exception.PetRequestedForAdoption;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.service.PetService;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/petConnect/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('SHELTER')")
    public ResponseEntity<PetDto> createPet(
            @AuthenticationPrincipal Jwt jwt,
            @RequestPart("pet") PetRequestDto request,
            @RequestPart("photoFiles") List<MultipartFile> files
    ) throws ResourceNotFoundException {


        Integer shelterId = ((Number) jwt.getClaim("id")).intValue();

        PetDto dto = new PetDto();
        dto.setAnimalType(request.getAnimalType());
        dto.setBreed(request.getBreed());
        dto.setAge(request.getAge());
        dto.setGender(request.getGender());
        dto.setDescription(request.getDescription());
        dto.setPrice(request.getPrice());
        dto.setPhotoFiles(files);

        PetDto created = petService.createPetForShelter(shelterId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


    @GetMapping
    @PreAuthorize("hasRole('SHELTER')")
    public ResponseEntity<List<PetDto>> getAll(@AuthenticationPrincipal Jwt jwt) {
        Long shelterId = jwt.getClaim("id");
        return ResponseEntity.ok(petService.getAllByShelterId(shelterId.intValue()));
    }
    @GetMapping("/all")

    public ResponseEntity<List<PetDto>> getAllPets(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('SHELTER') or hasRole('USER')")
    public ResponseEntity<PetDto> getOne(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable int id
    ) throws ResourceNotFoundException {
        Long shelterId = jwt.getClaim("id");
        return ResponseEntity.ok(petService.getByIdAndShelter(id, shelterId.intValue()));
    }
    @GetMapping("/public/{id}")
    public ResponseEntity<PetDto> getPetByIdForPublic(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('SHELTER')")
    public ResponseEntity<PetDto> update(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable int id,
            @RequestBody PetDto dto
    ) throws ResourceNotFoundException {
        Long shelterId = jwt.getClaim("id");
        return ResponseEntity.ok(petService.updatePetForShelter(id, shelterId.intValue(), dto));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('SHELTER')")
    public ResponseEntity<Void> delete(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable int id
    ) throws ResourceNotFoundException, PetRequestedForAdoption {
        Long shelterId = jwt.getClaim("id");
        petService.deletePetForShelter(id, shelterId.intValue());
        return ResponseEntity.noContent().build();
    }
}
