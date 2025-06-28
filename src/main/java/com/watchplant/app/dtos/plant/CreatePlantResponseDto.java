package com.watchplant.app.dtos.plant;

import com.watchplant.app.entities.PlantedPlant;
import com.watchplant.app.entities.keys.PlantedPlantKey;

import java.util.UUID;

/**
 * DTO for the response of creating a {@link PlantedPlant}.
 * Contains the details of the created plant.
 */
public class CreatePlantResponseDto {

  private final PlantedPlantKey key;
  private final String scientificName;
  private final String commonName;
  private final Integer quantity;

  /**
   * Constructor for {@link CreatePlantResponseDto}.
   *
   * @param plantedPlant The created {@link PlantedPlant}.
   */
  public CreatePlantResponseDto(PlantedPlant plantedPlant) {
    this.key = plantedPlant.getKey();
    this.scientificName = plantedPlant.getScientificName();
    this.commonName = plantedPlant.getCommonName();
    this.quantity = plantedPlant.getQuantity();
  }

  public PlantedPlantKey getKey() {
    return key;
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

  public Integer getQuantity() {
      return quantity;
  }
}
