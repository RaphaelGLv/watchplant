package com.watchplant.app.dtos.plant;

import com.watchplant.app.entities.Plant;

/**
 * DTO for the response of creating a {@link Plant}.
 * Contains the details of the created plant.
 */
public class CreatePlantResponseDto {

  private String scientificName;
  private String commonName;

  /**
   * Constructor for {@link CreatePlantResponseDto}.
   *
   * @param plant The created {@link Plant}.
   */
  public CreatePlantResponseDto(Plant plant) {
    this.scientificName = plant.getScientificName();
    this.commonName = plant.getCommonName();
  }

  /**
   * Gets the scientific name of the plant.
   *
   * @return The scientific name.
   */
  public String getScientificName() {
    return scientificName;
  }

  /**
   * Gets the common name of the plant.
   *
   * @return The common name.
   */
  public String getCommonName() {
    return commonName;
  }
}
