package com.watchplant.app.repositories;

import com.watchplant.app.entities.PlantedPlant;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the {@link PlantedPlant} entity.
 * Provides CRUD operations for managing plants in the database.
 */
@Repository
public interface PlantedPlantRepository extends JpaRepository<PlantedPlant, UUID> {
    List<PlantedPlant> findAllByPlantationId(UUID plantationId);
}