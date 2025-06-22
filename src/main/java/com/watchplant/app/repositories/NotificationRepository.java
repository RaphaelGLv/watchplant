package com.watchplant.app.repositories;

import com.watchplant.app.dtos.notification.GetAllNotificationsResponseDTO;
import com.watchplant.app.entities.Notification;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Notification entity.
 * Provides CRUD operations for Notification.
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    List<Notification> findAllByUserId(UUID userId);
}
