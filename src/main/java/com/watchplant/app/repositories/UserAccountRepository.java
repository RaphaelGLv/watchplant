package com.watchplant.app.repositories;

import com.watchplant.app.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
