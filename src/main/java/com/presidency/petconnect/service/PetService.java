package com.presidency.petconnect.service;

import com.presidency.petconnect.dto.PetDto;
import com.presidency.petconnect.exception.ResourceNotFoundException;

import java.util.List;

public interface PetService {

    PetDto createPet(PetDto petDto) throws ResourceNotFoundException;
    PetDto getPetById(int id) throws ResourceNotFoundException;
    PetDto updatePetById(int id , PetDto petDto) throws ResourceNotFoundException;
    List<PetDto> getAllPets();
    String deletePetById(int id) throws ResourceNotFoundException;
}
