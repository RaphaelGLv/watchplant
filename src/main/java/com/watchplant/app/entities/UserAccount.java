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
  @Table(name = "user_account")
  public class UserAccount {

    @Id
    private String email;
    private String password;
    private int loginTries;

    @OneToOne
    @MapsId
    @JoinColumn(name = "email")
    private User user;

    /**
     * Constructor for UserAccount
     * @param password The password of the user account
     * @throws IllegalArgumentException if email or password is null or empty, or if loginTries is negative
     */
    public UserAccount(String password, User user) {
      this.password = password;
      this.user = user;
      this.loginTries = 0;
    }

    public UserAccount() {}

    /**
     * Gets the email of the user account
     * @return The email of the user account
     */
    public String getEmail() {
      return email;
    }

    /**
     * Sets the email of the user account
     * @param email The email of the user account
     */
    public void setEmail(String email) {
      if (email == null || email.isEmpty()) {
        throw new IllegalArgumentException("Email cannot be null or empty");
      }
      this.email = email;
    }

    /**
     * Gets the password of the user account
     * @return The password of the user account
     */
    public String getPassword() {
      return password;
    }

    /**
     * Sets the password of the user account
     * @param password The password of the user account
     */
    public void setPassword(String password) {
      if (password == null || password.isEmpty()) {
        throw new IllegalArgumentException("Password cannot be null or empty");
      }
      this.password = password;
    }

    /**
     * Gets the number of login attempts
     * @return The number of login attempts
     */
    public int getLoginTries() {
      return loginTries;
    }

    /**
     * Sets the number of login attempts
     * @param loginTries The number of login attempts
     */
    public void setLoginTries(int loginTries) {
      if (loginTries < 0) {
        throw new IllegalArgumentException("Login tries cannot be negative");
      }
      this.loginTries = loginTries;
    }

    /**
     * Increments the number of login attempts
     */
    public void incrementLoginTries() {
      this.loginTries++;
    }

    /**
     * Resets the number of login attempts to zero
     */
    public void resetLoginTries() {
      this.loginTries = 0;
    }

    /**
     * Checks if the user account is blocked
     * @return true if the user account is locked, false otherwise
     */
    public boolean isBlocked() {
      return loginTries >= 3;
    }
  }
