package com.watchplant.app.entities;

import com.watchplant.app.entities.keys.NotificationKey;
import com.watchplant.app.entities.keys.PlantationKey;
import com.watchplant.app.entities.keys.PlantedPlantKey;
import com.watchplant.app.enums.NotificationTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author pedro
 */
@Entity
public class Notification {

  @EmbeddedId
  private NotificationKey key;

  @Column(insertable=false, updatable=false)
  private String userEmail;

  private LocalDateTime creationDate;
  private String message;
  private LocalDateTime seenAt;

  public Notification(
          String userEmail,
          PlantedPlantKey plantedPlantKey,
          LocalDateTime creationDate,
          String message,
          LocalDateTime seenAt,
          NotificationTypeEnum type
  ) {
    this.userEmail = userEmail;
    this.key = new NotificationKey(plantedPlantKey, type);
    this.creationDate = creationDate;
    this.message = message;
    this.seenAt = seenAt;
  }

  public Notification() {

  }

  /**
   * Gets the ID of the notification
   * @return The ID of the notification
   */
  public NotificationKey getKey() {
    return key;
  }

  /**
   * Gets the creation date of the notification
   * @return The creation date of the notification
   */
  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  /**
   * Sets the creation date of the notification
   * @param creationDate The creation date of the notification
   */
  public void setCreationDate(LocalDateTime creationDate) {
    if (creationDate == null) {
      throw new IllegalArgumentException("Creation date cannot be null");
    }
    this.creationDate = creationDate;
  }

  /**
   * Gets the message of the notification
   * @return The message of the notification
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the message of the notification
   * @param message The message of the notification
   */
  public void setMessage(String message) {
    if (message == null || message.isEmpty()) {
      throw new IllegalArgumentException("Message cannot be null or empty");
    }
    this.message = message;
  }

  /**
   * Gets the type of the notification
   * @return The type of the notification
   */
  public NotificationTypeEnum getType() {
    return this.key.getType();
  }

  public String getUserEmail() {
      return userEmail;
  }

  public Optional<LocalDateTime> getSeenAt() {
      return Optional.ofNullable(seenAt);
  }

  public void setSeenAt(LocalDateTime seenAt) {
    this.seenAt = seenAt;
  }
}
