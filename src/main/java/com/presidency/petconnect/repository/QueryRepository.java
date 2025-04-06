// src/main/java/com/example/petconnect/repository/QueryRepository.java
package com.presidency.petconnect.repository;

import com.presidency.petconnect.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {
    List<Query> findByShelterId(int id);
    // Additional query methods if needed
}
