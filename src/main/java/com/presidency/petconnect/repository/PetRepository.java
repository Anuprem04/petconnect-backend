package com.presidency.petconnect.repository;

import com.presidency.petconnect.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Integer> {
}
