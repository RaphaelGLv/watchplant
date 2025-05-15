/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

/**
 *
 * @author pedro
 */
@Entity
public class User {

  @Id
  private UUID id;

  private String name;
  private String email;
  private String phone;

  /**
   * Constructor for User
   * @param name The name of the user
   * @param email The email of the user
   * @param phone The phone number of the user
   * @throws IllegalArgumentException if name, email or phone is null or empty
   */
  public User(String name, String email, String phone) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    if (email == null || email.isEmpty()) {
      throw new IllegalArgumentException("Email cannot be null or empty");
    }
    if (phone == null || phone.isEmpty()) {
      throw new IllegalArgumentException("Phone cannot be null or empty");
    }
    this.id = UUID.randomUUID();
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  /**
   * Gets the ID of the user
   * @return The ID of the user
   */
  public UUID getId() {
    return id;
  }

  /**
   * Gets the name of the user
   * @return The name of the user
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the user
   * @param name The name of the user
   */
  public void setName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    this.name = name;
  }

  /**
   * Gets the email of the user
   * @return The email of the user
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email of the user
   * @param email The email of the user
   */
  public void setEmail(String email) {
    if (email == null || email.isEmpty()) {
      throw new IllegalArgumentException("Email cannot be null or empty");
    }
    this.email = email;
  }

  /**
   * Gets the phone number of the user
   * @return The phone number of the user
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets the phone number of the user
   * @param phone The phone number of the user
   */
  public void setPhone(String phone) {
    if (phone == null || phone.isEmpty()) {
      throw new IllegalArgumentException("Phone cannot be null or empty");
    }
    this.phone = phone;
  }
}
