package com.watchplant.app.repositories;

import com.watchplant.app.entities.Plantation;

import java.util.List;

import com.watchplant.app.entities.keys.PlantationKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Plantation entity.
 * Provides CRUD operations for Plantation.
 */
@Repository
public interface PlantationRepository extends JpaRepository<Plantation, PlantationKey> {
    List<Plantation> findAllByKey_userEmail(String keyUserEmail);
    void deleteAllByKey_userEmail(String keyUserEmail);
}
