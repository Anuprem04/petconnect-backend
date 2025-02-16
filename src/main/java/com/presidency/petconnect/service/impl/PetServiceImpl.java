
package com.presidency.petconnect.service.impl;

import com.presidency.petconnect.dto.PetDto;
import com.presidency.petconnect.entity.Pet;
import com.presidency.petconnect.entity.Shelter;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.mapper.PetMapper;
import com.presidency.petconnect.repository.PetRepository;
import com.presidency.petconnect.repository.ShelterRepository;
import com.presidency.petconnect.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final ShelterRepository shelterRepository;

    public PetServiceImpl(PetRepository petRepository, ShelterRepository shelterRepository) {
        this.petRepository = petRepository;
        this.shelterRepository = shelterRepository;
    }

    @Override
    public PetDto createPet(PetDto petDto) throws ResourceNotFoundException {
        Shelter shelter = shelterRepository.findById(petDto.getShelter().getShelterId())
                .orElseThrow(() -> new ResourceNotFoundException("Shelter not found"));
        Pet pet = PetMapper.mapToPet(petDto);
        pet.setShelter(shelter);
        Pet savedPet = petRepository.save(pet);
        return PetMapper.mapToPetDto(savedPet);
    }

    @Override
    public PetDto getPetById(int id) throws ResourceNotFoundException {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found"));
        return PetMapper.mapToPetDto(pet);
    }

    @Override
    public List<PetDto> getAllPets() {
        return petRepository.findAll().stream().map(PetMapper::mapToPetDto).collect(Collectors.toList());
    }

    @Override
    public PetDto updatePetById(int id, PetDto petDto) throws ResourceNotFoundException {
        Pet existingPet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found"));
        Shelter shelter = shelterRepository.findById(petDto.getShelter().getShelterId())
                .orElseThrow(() -> new ResourceNotFoundException("Shelter not found"));
        existingPet.setShelter(shelter);
        existingPet.setName(petDto.getName());
        existingPet.setBreed(petDto.getBreed());
        existingPet.setAge(petDto.getAge());
        existingPet.setGender(petDto.getGender());
        existingPet.setDescription(petDto.getDescription());
        existingPet.setPhotos(petDto.getPhotos());
        existingPet.setAdoptionStatus(petDto.getAdoptionStatus());
        existingPet.setPrice(petDto.getPrice());
        Pet updatedPet = petRepository.save(existingPet);
        return PetMapper.mapToPetDto(updatedPet);
    }

    @Override
    public String deletePetById(int id) throws ResourceNotFoundException {
        if (!petRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pet not found");
        }
        petRepository.deleteById(id);
        return "Pet with id "+id+" deleted successfully";
    }
}
