package com.watchplant.app.dtos.plant;

import java.util.UUID;

/**
 * DTO for fetching a {@link Plant} by ID.
 */
public class GetPlantRequestDto {

  private UUID id;

  /**
   * Constructor for {@link GetPlantRequestDto}.
   *
   * @param id The ID of the plant to fetch.
   */
  public GetPlantRequestDto(UUID id) {
    this.id = id;
  }

  /**
   * Gets the ID of the plant.
   *
   * @return The ID of the plant.
   */
  public UUID getId() {
    return id;
  }
}
