package com.presidency.petconnect.repository;

import com.presidency.petconnect.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdoptionRepository extends JpaRepository<Adoption,Integer> {
    boolean existsByUserUserIdAndPetPetId(int userId, int petId);

    List<Adoption> findByUserUserId(int userId);
}
