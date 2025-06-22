package com.watchplant.app.dtos.notification;

import com.watchplant.app.entities.Notification;
import com.watchplant.app.enums.NotificationTypeEnum;

import java.time.LocalDateTime;

/**
 * DTO for the response of fetching a notification.
 */
public class GetNotificationResponseDto {

  private final LocalDateTime creationDate;
  private final String message;
  private final boolean isSeen;
  private final NotificationTypeEnum type;

  public GetNotificationResponseDto(Notification notification) {
    this.creationDate = notification.getCreationDate();
    this.message = notification.getMessage();
    this.isSeen = notification.isSeen();
    this.type = notification.getType();
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public String getMessage() {
    return message;
  }

  public boolean isSeen() {
    return isSeen;
  }

  public NotificationTypeEnum getType() {
    return type;
  }
}
