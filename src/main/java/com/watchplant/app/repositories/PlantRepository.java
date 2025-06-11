package com.watchplant.app.repositories;

import com.watchplant.app.entities.PlantedPlant;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the {@link PlantedPlant} entity.
 * Provides CRUD operations for managing plants in the database.
 */
@Repository
public interface PlantRepository extends JpaRepository<PlantedPlant, UUID> {}
