package com.watchplant.app.dtos.plantedPlant;

import com.watchplant.app.entities.PlantedPlant;
import com.watchplant.app.entities.keys.PlantedPlantKey;
import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;
import com.watchplant.app.enums.WateringFrequencyEnum;

/**
 * DTO for the response of fetching a {@link PlantedPlant}.
 * Contains the details of the fetched plant.
 */
public class GetPlantedPlantResponseDto {
  private final PlantedPlantKey plantedPlantKey;

  private final WateringFrequencyEnum wateringFrequency;
  private final SunlightIncidenceEnum sunlightIncidence;
  private final SoilTypeEnum soilType;
  private final String scientificName;
  private final String commonName;
  private final Integer quantity;

  public GetPlantedPlantResponseDto(PlantedPlant plant) {
    plantedPlantKey = plant.getKey();
    wateringFrequency = plant.getWateringFrequency();
    sunlightIncidence = plant.getSunlightIncidence();
    soilType = plant.getSoilType();
    scientificName = plant.getScientificName();
    commonName = plant.getCommonName();
    quantity = plant.getQuantity();
  }

  public PlantedPlantKey getPlantedPlantKey() {
    return plantedPlantKey;
  }

  public WateringFrequencyEnum getWateringFrequency() {
    return wateringFrequency;
  }

  public SunlightIncidenceEnum getSunlightIncidence() {
    return sunlightIncidence;
  }

  public SoilTypeEnum getSoilType() {
    return soilType;
  }

  public String getScientificName() {
    return scientificName;
  }

  public String getCommonName() {
    return commonName;
  }

  public Integer getQuantity() {
    return quantity;
  }
}
