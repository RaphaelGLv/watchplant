package com.watchplant.app.dtos.notification;

import java.time.LocalDateTime;

/**
 * DTO for creating a notification.
 */
public class CreateNotificationRequestDto {

  private LocalDateTime creationDate;
  private String message;
  private boolean isSeen;
  private int type;

  public CreateNotificationRequestDto(LocalDateTime creationDate, String message, boolean isSeen, int type) {
    this.creationDate = creationDate;
    this.message = message;
    this.isSeen = isSeen;
    this.type = type;
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

  public int getType() {
    return type;
  }
}
