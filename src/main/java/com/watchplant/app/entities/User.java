/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.entities;

import jakarta.persistence.*;

import java.util.UUID;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "users")
public class User {

  @Id
  private String email;
  private String name;
  private String phone;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private Address address;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private UserAccount account;
  /**
   * Constructor for User
   * @param name The name of the user
   * @param email The email of the user
   * @param phone The phone number of the user
   * @throws IllegalArgumentException if name, email or phone is null or empty
   */
  public User(String name, String email, String phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  public User() {}

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }
}
