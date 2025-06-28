/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.dtos.address;

import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author pedro
 */
public class UpdateAddressRequestDto {

  private Optional<String> zipCode;
  private Optional<String> street;
  private Optional<String> number;
  private Optional<String> neighborhood;

  /**
   * Constructor for UpdateAddressRequestDto
   *
   * @param zipCode The zip code of the address (nullable)
   * @param street The street of the address (nullable)
   * @param number The number of the address (nullable)
   * @param neighborhood The neighborhood of the address (nullable)
   */
  public UpdateAddressRequestDto(
    String zipCode,
    String street,
    String number,
    String neighborhood
  ) {
    this.zipCode = Optional.ofNullable(zipCode);
    this.street = Optional.ofNullable(street);
    this.number = Optional.ofNullable(number);
    this.neighborhood = Optional.ofNullable(neighborhood);
  }

  /**
   * Gets the zip code of the address
   * @return An Optional containing the zip code of the address
   */
  public Optional<String> getZipCode() {
    return zipCode;
  }

  /**
   * Sets the zip code of the address
   * @param zipCode The zip code of the address (nullable)
   */
  public void setZipCode(String zipCode) {
    this.zipCode = Optional.ofNullable(zipCode);
  }

  /**
   * Gets the street of the address
   * @return An Optional containing the street of the address
   */
  public Optional<String> getStreet() {
    return street;
  }

  /**
   * Sets the street of the address
   * @param street The street of the address (nullable)
   */
  public void setStreet(String street) {
    this.street = Optional.ofNullable(street);
  }

  /**
   * Gets the number of the address
   * @return An Optional containing the number of the address
   */
  public Optional<String> getNumber() {
    return number;
  }

  /**
   * Sets the number of the address
   * @param number The number of the address (nullable)
   */
  public void setNumber(String number) {
    this.number = Optional.ofNullable(number);
  }

  /**
   * Gets the neighborhood of the address
   * @return An Optional containing the neighborhood of the address
   */
  public Optional<String> getNeighborhood() {
    return neighborhood;
  }

  /**
   * Sets the neighborhood of the address
   * @param neighborhood The neighborhood of the address (nullable)
   */
  public void setNeighborhood(String neighborhood) {
    this.neighborhood = Optional.ofNullable(neighborhood);
  }
}
