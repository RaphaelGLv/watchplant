package com.watchplant.app.dtos.plant;

import com.watchplant.app.entities.PlantedPlant;

/**
 * DTO for the response of creating a {@link PlantedPlant}.
 * Contains the details of the created plant.
 */
public class CreatePlantResponseDto {

  private final String scientificName;
  private final String commonName;
  private final Integer quantity;
  private final String plantationName;

  /**
   * Constructor for {@link CreatePlantResponseDto}.
   *
   * @param plantedPlant The created {@link PlantedPlant}.
   */
  public CreatePlantResponseDto(PlantedPlant plantedPlant, Integer quantity, String plantationName) {
    this.scientificName = plantedPlant.getScientificName();
    this.commonName = plantedPlant.getCommonName();
    this.quantity = plantedPlant.getQuantity();
    this.plantationName = plantationName;
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

  public String getPlantationName() {
      return plantationName;
  }

  public Integer getQuantity() {
      return quantity;
  }
}
