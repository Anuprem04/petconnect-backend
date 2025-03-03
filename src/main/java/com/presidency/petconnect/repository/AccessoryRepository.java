
package com.presidency.petconnect.repository;

import com.presidency.petconnect.entity.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Integer> {
}
