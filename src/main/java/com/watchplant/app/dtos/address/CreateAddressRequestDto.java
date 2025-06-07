/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.dtos.address;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author pedro
 */
public class CreateAddressRequestDto {

  @NotBlank(message = "O CEP é um campo obrigatório")
  private String zipCode;

  @NotBlank(message = "A rua é um campo obrigatório")
  private String street;

  @NotBlank(message = "O número do endereço é um campo obrigatório")
  private String number;

  @NotBlank(message = "O bairro é um campo obrigatório")
  private String neighborhood;

  /**
   * Gets the zip code of the address
   * @return The zip code of the address
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * Sets the zip code of the address
   * @param zipCode The zip code of the address
   */
  public void setZipCode(String zipCode) {
    if (zipCode == null || zipCode.isEmpty()) {
      throw new IllegalArgumentException("Zip code cannot be null or empty");
    }
    this.zipCode = zipCode;
  }

  /**
   * Gets the street of the address
   * @return The street of the address
   */
  public String getStreet() {
    return street;
  }

  /**
   * Sets the street of the address
   * @param street The street of the address
   */
  public void setStreet(String street) {
    if (street == null || street.isEmpty()) {
      throw new IllegalArgumentException("Street cannot be null or empty");
    }
    this.street = street;
  }

  /**
   * Gets the number of the address
   * @return The number of the address
   */
  public String getNumber() {
    return number;
  }

  /**
   * Sets the number of the address
   * @param number The number of the address
   */
  public void setNumber(String number) {
    if (number == null || number.isEmpty()) {
      throw new IllegalArgumentException("Number cannot be null or empty");
    }
    this.number = number;
  }

  /**
   * Gets the neighborhood of the address
   * @return The neighborhood of the address
   */
  public String getNeighborhood() {
    return neighborhood;
  }

  /**
   * Sets the neighborhood of the address
   * @param neighborhood The neighborhood of the address
   */
  public void setNeighborhood(String neighborhood) {
    if (neighborhood == null || neighborhood.isEmpty()) {
      throw new IllegalArgumentException(
        "Neighborhood cannot be null or empty"
      );
    }
    this.neighborhood = neighborhood;
  }
}
