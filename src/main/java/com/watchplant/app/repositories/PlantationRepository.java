package com.watchplant.app.repositories;

import com.watchplant.app.entities.Plantation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Plantation entity.
 * Provides CRUD operations for Plantation.
 */
@Repository
public interface PlantationRepository extends JpaRepository<Plantation, UUID> {
    public List<Plantation> findAllByOwnerId(UUID ownerId);
    public Optional<Plantation> findByIdAndOwnerId(UUID id, UUID ownerId);
    public boolean existsByOwnerIdAndName(UUID ownerId, String plantationName);
}
