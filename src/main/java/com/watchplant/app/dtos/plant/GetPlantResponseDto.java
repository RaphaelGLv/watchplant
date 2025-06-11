package com.watchplant.app.dtos.plant;

import com.watchplant.app.entities.PlantedPlant;

/**
 * DTO for the response of fetching a {@link PlantedPlant}.
 * Contains the details of the fetched plant.
 */
public class GetPlantResponseDto {

  private String scientificName;
  private String commonName;

  /**
   * Constructor for {@link GetPlantResponseDto}.
   *
   * @param plantedPlant The fetched {@link PlantedPlant}.
   */
  public GetPlantResponseDto(PlantedPlant plantedPlant) {
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
