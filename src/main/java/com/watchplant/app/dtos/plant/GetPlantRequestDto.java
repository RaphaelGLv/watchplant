package com.watchplant.app.dtos.plant;

import com.watchplant.app.entities.keys.PlantedPlantKey;


public class GetPlantRequestDto {

  private PlantedPlantKey key;

  public GetPlantRequestDto(PlantedPlantKey key) {
    this.key = key;
  }
  public PlantedPlantKey getKey() {
    return key;
  }
}
