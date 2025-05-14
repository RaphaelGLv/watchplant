/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.dtos.address;

import java.util.UUID;

/**
 * DTO for fetching an address by ID.
 */
public class GetAddressRequestDto {

  private UUID id;

  /**
   * Constructor for GetAddressRequestDto.
   *
   * @param id The ID of the address to fetch.
   */
  public GetAddressRequestDto(UUID id) {
    this.id = id;
  }

  /**
   * Gets the ID of the address.
   *
   * @return The ID of the address.
   */
  public UUID getId() {
    return id;
  }
}
