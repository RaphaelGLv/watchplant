/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.dtos.address;

import com.watchplant.app.entities.Address;

/**
 *
 * @author pedro
 */
public class UpdateAddressResponseDto {

  private Address address;

  /**
   * Constructor for UpdateAddressResponseDto
   *
   * @param address The address to be updated
   */
  public UpdateAddressResponseDto(Address address) {
    this.address = address;
  }

  /**
   * Gets the address
   *
   * @return The address
   */
  public Address getAddress() {
    return address;
  }
}
