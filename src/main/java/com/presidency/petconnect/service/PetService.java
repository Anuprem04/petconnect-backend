package com.presidency.petconnect.service;

import com.presidency.petconnect.dto.AdoptionDto;
import com.presidency.petconnect.dto.PetDto;
import com.presidency.petconnect.entity.Pet;
import com.presidency.petconnect.exception.PetRequestedForAdoption;
import com.presidency.petconnect.exception.ResourceNotFoundException;

import java.util.List;

public interface PetService {

    PetDto createPetForShelter(Integer shelterId, PetDto petDto) throws ResourceNotFoundException;

    List<PetDto> getAllByShelterId(Integer shelterId);

    PetDto getByIdAndShelter(Integer petId, Integer shelterId) throws ResourceNotFoundException;

    PetDto updatePetForShelter(Integer petId, Integer shelterId, PetDto petDto) throws ResourceNotFoundException;

    void deletePetForShelter(Integer petId, Integer shelterId) throws ResourceNotFoundException, PetRequestedForAdoption;

    List<PetDto> getAllPets();

    PetDto getPetById(int id) throws ResourceNotFoundException;

}
