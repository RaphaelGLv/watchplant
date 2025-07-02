package com.watchplant.app.dtos.plantedPlant;

import com.watchplant.app.entities.keys.PlantedPlantKey;


public class GetPlantedPlantRequestDto {

  private PlantedPlantKey key;

  public GetPlantedPlantRequestDto(PlantedPlantKey key) {
    this.key = key;
  }
  public PlantedPlantKey getKey() {
    return key;
  }
}
