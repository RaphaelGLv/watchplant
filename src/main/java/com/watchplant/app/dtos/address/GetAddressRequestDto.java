/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.dtos.address;

import java.util.UUID;

/**
 *
 * @author pedro
 */
public class GetAddressRequestDto {

  private UUID id;

  /**
   * Constructor for GetAddressRequestDto
   *
   * @param id The id of the address
   */
  public GetAddressRequestDto(UUID id) {
    this.id = id;
  }

  /**
   * Gets the id of the address
   *
   * @return The id of the address
   */
  public UUID getId() {
    return id;
  }
}
