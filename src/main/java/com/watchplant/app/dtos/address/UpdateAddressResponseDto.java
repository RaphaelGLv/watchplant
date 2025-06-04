/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.dtos.address;

import com.watchplant.app.entities.Address;

/**
 * DTO for the response of updating an address.
 * Contains the updated address details.
 */
public class UpdateAddressResponseDto {

  private Address address;

  /**
   * Constructor for UpdateAddressResponseDto.
   *
   * @param address The updated address.
   */
  public UpdateAddressResponseDto(Address address) {
    this.address = address;
  }

  /**
   * Gets the updated address.
   *
   * @return The updated address.
   */
  public Address getAddress() {
    return address;
  }
}
