/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.entities;

import java.time.LocalDateTime;

/**
 *
 * @author pedro
 */
public class Notification {

  private LocalDateTime creationDate;
  private String message;
  private boolean isSeen;
  private int type;

  /**
   * Constructor for Notification
   * @param creationDate The creation date of the notification
   * @param message The message of the notification
   * @param isSeen Whether the notification has been seen
   * @param type The type of the notification
   * @throws IllegalArgumentException if creationDate or message is null, or if message is empty
   */
  public Notification(
    LocalDateTime creationDate,
    String message,
    boolean isSeen,
    int type
  ) {
    if (creationDate == null) {
      throw new IllegalArgumentException("Creation date cannot be null");
    }
    if (message == null || message.isEmpty()) {
      throw new IllegalArgumentException("Message cannot be null or empty");
    }
    this.creationDate = creationDate;
    this.message = message;
    this.isSeen = isSeen;
    this.type = type;
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
   * Checks if the notification has been seen
   * @return True if the notification has been seen, false otherwise
   */
  public boolean isSeen() {
    return isSeen;
  }

  /**
   * Sets the seen status of the notification
   * @param isSeen Whether the notification has been seen
   */
  public void setSeen(boolean isSeen) {
    this.isSeen = isSeen;
  }

  /**
   * Gets the type of the notification
   * @return The type of the notification
   */
  public int getType() {
    return type;
  }

  /**
   * Sets the type of the notification
   * @param type The type of the notification
   */
  public void setType(int type) {
    this.type = type;
  }
}
