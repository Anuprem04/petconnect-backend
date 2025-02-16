
package com.presidency.petconnect.service.impl;

import com.presidency.petconnect.dto.AdoptionDto;
import com.presidency.petconnect.entity.Adoption;
import com.presidency.petconnect.entity.Pet;
import com.presidency.petconnect.entity.User;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.mapper.AdoptionMapper;
import com.presidency.petconnect.repository.AdoptionRepository;
import com.presidency.petconnect.repository.PetRepository;
import com.presidency.petconnect.repository.UserRepository;
import com.presidency.petconnect.service.AdoptionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptionServiceImpl implements AdoptionService {

    private final AdoptionRepository adoptionRepository;
    private final PetRepository petRepository;
    private final UserRepository userRepository;

    public AdoptionServiceImpl(AdoptionRepository adoptionRepository, PetRepository petRepository, UserRepository userRepository) {
        this.adoptionRepository = adoptionRepository;
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AdoptionDto createAdoption(AdoptionDto adoptionDto) throws ResourceNotFoundException {
        Pet pet = petRepository.findById(adoptionDto.getPetId())
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found"));
        User user = userRepository.findById(adoptionDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Adoption adoption = AdoptionMapper.toEntity(adoptionDto, pet, user);
        Adoption saved = adoptionRepository.save(adoption);
        return AdoptionMapper.toDto(saved);
    }

    @Override
    public AdoptionDto getAdoptionById(int id) throws ResourceNotFoundException {
        Adoption adoption = adoptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Adoption not found"));
        return AdoptionMapper.toDto(adoption);
    }

    @Override
    public List<AdoptionDto> getAllAdoptions() {
        return adoptionRepository.findAll().stream().map(AdoptionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AdoptionDto updateAdoption(int id, AdoptionDto adoptionDto) throws ResourceNotFoundException {
        Adoption adoption = adoptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Adoption not found"));
        adoption.setApprovalStatus(adoptionDto.getApprovalStatus());
        Adoption updated = adoptionRepository.save(adoption);
        return AdoptionMapper.toDto(updated);
    }

    @Override
    public String deleteAdoption(int id) throws ResourceNotFoundException {
        if (!adoptionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Adoption not found");
        }
        adoptionRepository.deleteById(id);
        return "Adoption with id "+id+" deleted successfully";
    }
}
