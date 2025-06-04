package com.watchplant.app.dtos.plantation;

import java.util.UUID;

/**
 * DTO for fetching a plantation by ID.
 */
public class GetPlantationRequestDto {

  private UUID id;

  /**
   * Constructor for GetPlantationRequestDto.
   *
   * @param id The ID of the plantation to fetch.
   */
  public GetPlantationRequestDto(UUID id) {
    this.id = id;
  }

  /**
   * Gets the ID of the plantation.
   *
   * @return The ID of the plantation.
   */
  public UUID getId() {
    return id;
  }
}
