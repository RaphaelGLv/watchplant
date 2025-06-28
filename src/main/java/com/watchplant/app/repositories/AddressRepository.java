package com.watchplant.app.repositories;

import com.watchplant.app.entities.Address;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Address entity.
 * Provides CRUD operations for Address.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, String> {}
