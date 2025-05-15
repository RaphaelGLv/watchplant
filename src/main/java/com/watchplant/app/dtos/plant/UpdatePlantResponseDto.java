package com.watchplant.app.dtos.plant;

import com.watchplant.app.entities.Plant;

/**
 * DTO for the response of updating a {@link Plant}.
 * Contains the updated details of the plant.
 */
public class UpdatePlantResponseDto {

  private String scientificName;
  private String commonName;

  /**
   * Constructor for {@link UpdatePlantResponseDto}.
   *
   * @param plant The updated {@link Plant}.
   */
  public UpdatePlantResponseDto(Plant plant) {
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
