package com.watchplant.app.dtos.notification;

import java.util.UUID;

/**
 * DTO for fetching a notification by ID.
 */
public class GetNotificationRequestDto {

  private UUID id;

  /**
   * Constructor for GetNotificationRequestDto.
   *
   * @param id The ID of the notification to fetch.
   */
  public GetNotificationRequestDto(UUID id) {
    this.id = id;
  }

  /**
   * Gets the ID of the notification.
   *
   * @return The ID of the notification.
   */
  public UUID getId() {
    return id;
  }
}
