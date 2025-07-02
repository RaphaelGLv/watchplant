package com.watchplant.app.dtos.plantedPlant;

import com.watchplant.app.entities.keys.PlantedPlantKey;
import com.watchplant.app.enums.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public class UpdatePlantedPlantRequestDto {

  private PlantedPlantKey plantedPlantKey;

  private WateringFrequencyEnum wateringFrequency;
  private SunlightIncidenceEnum sunlightIncidence;
  private SoilTypeEnum soilType;

  @Min(value = 1, message = "A quantidade de plantas deve ser maior ou igual a 1")
  private Integer quantity;

  public UpdatePlantedPlantRequestDto(
    PlantedPlantKey plantedPlantKey,
    WateringFrequencyEnum wateringFrequency,
    SunlightIncidenceEnum sunlightIncidence,
    SoilTypeEnum soilType,
    Integer quantity
  ) {
    this.plantedPlantKey = plantedPlantKey;
    this.wateringFrequency = wateringFrequency;
    this.sunlightIncidence = sunlightIncidence;
    this.soilType = soilType;
    this.quantity = quantity;
  }

  public PlantedPlantKey getPlantedPlantKey() {
    return plantedPlantKey;
  }

  public Optional<WateringFrequencyEnum> getWateringFrequency() {
    return Optional.ofNullable(wateringFrequency);
  }

  public Optional<SunlightIncidenceEnum> getSunlightIncidence() {
    return Optional.ofNullable(sunlightIncidence);
  }

  public Optional<SoilTypeEnum> getSoilType() {
    return Optional.ofNullable(soilType);
  }

  public Optional<Integer> getQuantity() {
    return Optional.ofNullable(quantity);
  }

  public void setPlantedPlantKey(PlantedPlantKey plantedPlantKey) {
    this.plantedPlantKey = plantedPlantKey;
  }
}
