package com.watchplant.app.repositories;

import com.watchplant.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByAccount_Id(UUID accountId);
}
