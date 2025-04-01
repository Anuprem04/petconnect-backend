
package com.presidency.petconnect.controller;

import com.nimbusds.jwt.util.DateUtils;
import com.presidency.petconnect.dto.AdoptionDto;
import com.presidency.petconnect.entity.APPROVAL_STATUS;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.service.AdoptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/petConnect/adoptions")
public class AdoptionController {

    private final AdoptionService service;

    public AdoptionController(AdoptionService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> requestAdoption(
            @AuthenticationPrincipal Jwt jwt,
            @RequestBody AdoptionDto dto) throws ResourceNotFoundException {
        System.out.println(jwt.getClaim("id") instanceof  Integer);
        Long userId = jwt.getClaim("id");
        dto.setUserId(userId.intValue());
        dto.setApplicationDate(LocalDate.now());
        dto.setApprovalStatus(APPROVAL_STATUS.PENDING.getLabel());

        // Check if the same user has already requested for the same pet
        if (service.existsByUserIdAndPetId(userId.intValue(), dto.getPetId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("You have already submitted an adoption request for this pet.");
        }

        AdoptionDto saved = service.createAdoption(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }



    @GetMapping("/{id}")
    public ResponseEntity<AdoptionDto> getById(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.getAdoptionById(id));
    }

    @GetMapping
    public ResponseEntity<List<AdoptionDto>> getAll() {
        return ResponseEntity.ok(service.getAllAdoptions());
    }
    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<AdoptionDto>> getAdoptionsByUser(@AuthenticationPrincipal Jwt jwt, @PathVariable String id) {
        Long userId = jwt.getClaim("id");
        List<AdoptionDto> adoptions = service.getAdoptionsByUserId(userId.intValue());
        return ResponseEntity.ok(adoptions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdoptionDto> update(@PathVariable int id, @RequestBody AdoptionDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateAdoption(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException {
        service.deleteAdoption(id);
        return ResponseEntity.ok("Adoption deleted");
    }
}
