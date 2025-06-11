package com.watchplant.app.dtos.plant;

import com.watchplant.app.entities.PlantedPlant;

/**
 * DTO for the response of updating a {@link PlantedPlant}.
 * Contains the updated details of the plant.
 */
public class UpdatePlantResponseDto {

  private String scientificName;
  private String commonName;

  /**
   * Constructor for {@link UpdatePlantResponseDto}.
   *
   * @param plantedPlant The updated {@link PlantedPlant}.
   */
  public UpdatePlantResponseDto(PlantedPlant plantedPlant) {
    this.scientificName = plantedPlant.getScientificName();
    this.commonName = plantedPlant.getCommonName();
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
