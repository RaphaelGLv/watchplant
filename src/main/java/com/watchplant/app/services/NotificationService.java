/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.services;

import com.watchplant.app.dtos.notification.CreateNotificationRequestDto;
import com.watchplant.app.dtos.notification.CreateNotificationResponseDto;
import com.watchplant.app.dtos.notification.GetNotificationRequestDto;
import com.watchplant.app.dtos.notification.GetNotificationResponseDto;
import com.watchplant.app.entities.Notification;
import com.watchplant.app.repositories.NotificationRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * Service class for managing Notification entities.
 */
@Service
public class NotificationService {

  private NotificationRepository notificationRepository;

  /**
   * Creates a new notification.
   * @param request The request containing notification details.
   * @return {@link CreateNotificationResponseDto} containing the created notification details.
   */
  public CreateNotificationResponseDto createNotification(
    CreateNotificationRequestDto request
  ) {
    Notification notification = new Notification(
      request.getCreationDate(),
      request.getMessage(),
      request.isSeen(),
      request.getType()
    );
    notificationRepository.save(notification);
    return new CreateNotificationResponseDto(notification);
  }

  /**
   * Fetches a notification by ID.
   * @param id The ID of the notification.
   * @return {@link GetNotificationResponseDto} containing the notification details.
   * @throws IllegalArgumentException if the notification is not found.
   */
  public GetNotificationResponseDto getNotification(
    GetNotificationRequestDto request
  ) {
    UUID id = request.getId();
    Notification notification = notificationRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Notification not found")
      );
    return new GetNotificationResponseDto(notification);
  }
}
