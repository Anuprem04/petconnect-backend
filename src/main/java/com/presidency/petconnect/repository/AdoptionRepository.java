package com.presidency.petconnect.repository;

import com.presidency.petconnect.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepository extends JpaRepository<Adoption,Integer> {
}
