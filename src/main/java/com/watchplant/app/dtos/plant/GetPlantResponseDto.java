package com.watchplant.app.dtos.plant;

import com.watchplant.app.entities.Plant;

/**
 * DTO for the response of fetching a {@link Plant}.
 * Contains the details of the fetched plant.
 */
public class GetPlantResponseDto {

  private String scientificName;
  private String commonName;

  /**
   * Constructor for {@link GetPlantResponseDto}.
   *
   * @param plant The fetched {@link Plant}.
   */
  public GetPlantResponseDto(Plant plant) {
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
