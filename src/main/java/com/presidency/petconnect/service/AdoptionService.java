
package com.presidency.petconnect.service;

import com.presidency.petconnect.dto.AdoptionDto;
import com.presidency.petconnect.exception.ResourceNotFoundException;

import java.util.List;

public interface AdoptionService {
    AdoptionDto createAdoption(AdoptionDto adoptionDto) throws ResourceNotFoundException;
    AdoptionDto getAdoptionById(int id) throws ResourceNotFoundException;
    List<AdoptionDto> getAllAdoptions();
    AdoptionDto updateAdoption(int id, AdoptionDto adoptionDto) throws ResourceNotFoundException;
    String deleteAdoption(int id) throws ResourceNotFoundException;
    boolean existsByUserIdAndPetId(int userId, int petId);

    List<AdoptionDto> getAdoptionsByUserId(int userId);
}
