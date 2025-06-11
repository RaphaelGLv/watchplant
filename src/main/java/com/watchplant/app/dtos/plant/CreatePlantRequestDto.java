package com.watchplant.app.dtos.plant;

import com.watchplant.app.dtos.plantation.PlantationPreviewDto;
import com.watchplant.app.entities.PlantedPlant;
import com.watchplant.app.enums.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/**
 * DTO for creating a {@link PlantedPlant]}.
 * Contains the required fields for creating a new plant.
 */
public class CreatePlantRequestDto {

  @NotNull(message = "A planta é um campo obrigatório")
  @Min(value = 1, message = "O id da planta deve ser maior ou igual a 1")
  private Integer plantId;

  @Valid
  private PlantationPreviewDto plantation;

  @NotNull(message = "A quantidade de plantas é um campo obrigatório")
  @Min(value = 1, message = "A quantidade de plantas deve ser maior ou igual a 1")
  private Integer quantity;

  private final Long plantationDateInMs = System.currentTimeMillis();

  @NotNull(message = "A frequência de rega é um campo obrigatório")
  private WateringFrequencyEnum wateringFrequency;

  @NotNull(message = "A frequência de incidência solar é um campo obtrigatório")
  private SunlightIncidenceEnum sunlightIncidence;

  @NotNull(message = "O tipo de solo é um campo obrigatório")
  private SoilTypeEnum soilType;

  /**
   * Gets the watering frequency of the plant.
   *
   * @return The watering frequency of the plant.
   */
  public WateringFrequencyEnum getWateringFrequency() {
    return wateringFrequency;
  }

  /**
   * Gets the sunlight incidence required by the plant.
   *
   * @return The sunlight incidence required by the plant.
   */
  public SunlightIncidenceEnum getSunlightIncidence() {
    return sunlightIncidence;
  }

  /**
   * Gets the soil type suitable for the plant.
   *
   * @return The soil type suitable for the plant.
   */
  public SoilTypeEnum getSoilType() {
    return soilType;
  }

  public Integer getPlantId() {
    return plantId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public Long getPlantationDateInMs() {
    return plantationDateInMs;
  }

  public PlantationPreviewDto getPlantation() {
      return plantation;
  }
}
