package com.presidency.petconnect.repository;

import com.presidency.petconnect.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet,Integer> {

    List<Pet> findByShelter_ShelterId(Integer shelterId);

    Optional<Pet> findByPetIdAndShelter_ShelterId(Integer petId, Integer shelterId);

    boolean existsByPetIdAndShelter_ShelterId(Integer petId, Integer shelterId);
}
