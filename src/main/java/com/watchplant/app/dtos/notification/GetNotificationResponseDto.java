package com.watchplant.app.dtos.notification;

import com.watchplant.app.entities.Notification;
import com.watchplant.app.entities.keys.NotificationKey;
import com.watchplant.app.enums.NotificationTypeEnum;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * DTO for the response of fetching a notification.
 */
public class GetNotificationResponseDto {

  private final NotificationKey key;
  private final LocalDateTime creationDate;
  private final String message;
  private final Optional<LocalDateTime> seenAt;
  private final NotificationTypeEnum type;

  public GetNotificationResponseDto(Notification notification) {
    this.key = notification.getKey();
    this.creationDate = notification.getCreationDate();
    this.message = notification.getMessage();
    this.seenAt = notification.getSeenAt();
    this.type = notification.getType();
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public String getMessage() {
    return message;
  }

  public Optional<LocalDateTime> getSeenAt() {
    return seenAt;
  }

  public NotificationTypeEnum getType() {
    return type;
  }

  public NotificationKey getKey() {
      return key;
  }
}
