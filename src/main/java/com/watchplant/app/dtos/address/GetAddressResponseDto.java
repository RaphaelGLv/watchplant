/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.dtos.address;

import com.watchplant.app.entities.Address;
import java.util.UUID;

/**
 * DTO for the response of fetching an address.
 * Contains the details of the fetched address.
 */
public class GetAddressResponseDto {

  private String userEmail;
  private String zipCode;
  private String street;
  private String number;
  private String neighborhood;

  /**
   * Constructor for GetAddressResponseDto.
   *
   * @param address The fetched address.
   */
  public GetAddressResponseDto(Address address) {
    this.userEmail = address.getUserEmail();
    this.zipCode = address.getZipCode();
    this.street = address.getStreet();
    this.number = address.getNumber();
    this.neighborhood = address.getNeighborhood();
  }

  /**
   * Gets the ID of the address.
   *
   * @return The ID of the address.
   */
  public String getUserEmail() {
    return userEmail;
  }

  /**
   * Gets the zip code of the address.
   *
   * @return The zip code of the address.
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * Gets the street of the address.
   *
   * @return The street of the address.
   */
  public String getStreet() {
    return street;
  }

  /**
   * Gets the number of the address.
   *
   * @return The number of the address.
   */
  public String getNumber() {
    return number;
  }

  /**
   * Gets the neighborhood of the address.
   *
   * @return The neighborhood of the address.
   */
  public String getNeighborhood() {
    return neighborhood;
  }
}
