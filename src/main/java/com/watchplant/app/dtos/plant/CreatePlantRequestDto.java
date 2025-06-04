package com.watchplant.app.dtos.plant;

import com.watchplant.app.enums.*;

/**
 * DTO for creating a {@link Plant}.
 * Contains the required fields for creating a new plant.
 */
public class CreatePlantRequestDto {

  private String scientificName;
  private String commonName;
  private Double maxFeetHeight;
  private PlantCycleEnum cycle;
  private WateringFrequencyEnum wateringFrequency;
  private SunlightIncidenceEnum sunlightIncidence;
  private int pruningMonth;
  private int pruningCountYearly;
  private SoilTypeEnum soilType;
  private CareLevelEnum careLevel;

  /**
   * Constructor for {@link CreatePlantRequestDto}.
   *
   * @param scientificName The scientific name of the plant.
   * @param commonName The common name of the plant.
   * @param maxFeetHeight The maximum height of the plant in feet.
   * @param cycle The life cycle of the plant.
   * @param wateringFrequency The watering frequency of the plant.
   * @param sunlightIncidence The sunlight incidence required by the plant.
   * @param pruningMonth The month for pruning the plant.
   * @param pruningCountYearly The yearly pruning count for the plant.
   * @param soilType The soil type suitable for the plant.
   * @param careLevel The care level required for the plant.
   */
  public CreatePlantRequestDto(
    String scientificName,
    String commonName,
    Double maxFeetHeight,
    PlantCycleEnum cycle,
    WateringFrequencyEnum wateringFrequency,
    SunlightIncidenceEnum sunlightIncidence,
    int pruningMonth,
    int pruningCountYearly,
    SoilTypeEnum soilType,
    CareLevelEnum careLevel
  ) {
    this.scientificName = scientificName;
    this.commonName = commonName;
    this.maxFeetHeight = maxFeetHeight;
    this.cycle = cycle;
    this.wateringFrequency = wateringFrequency;
    this.sunlightIncidence = sunlightIncidence;
    this.pruningMonth = pruningMonth;
    this.pruningCountYearly = pruningCountYearly;
    this.soilType = soilType;
    this.careLevel = careLevel;
  }

  /**
   * Gets the scientific name of the plant.
   *
   * @return The scientific name of the plant.
   */
  public String getScientificName() {
    return scientificName;
  }

  /**
   * Gets the common name of the plant.
   *
   * @return The common name of the plant.
   */
  public String getCommonName() {
    return commonName;
  }

  /**
   * Gets the maximum height of the plant in feet.
   *
   * @return The maximum height of the plant in feet.
   */
  public Double getMaxFeetHeight() {
    return maxFeetHeight;
  }

  /**
   * Gets the life cycle of the plant.
   *
   * @return The life cycle of the plant.
   */
  public PlantCycleEnum getCycle() {
    return cycle;
  }

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
   * Gets the month for pruning the plant.
   *
   * @return The month for pruning the plant.
   */
  public int getPruningMonth() {
    return pruningMonth;
  }

  /**
   * Gets the yearly pruning count for the plant.
   *
   * @return The yearly pruning count for the plant.
   */
  public int getPruningCountYearly() {
    return pruningCountYearly;
  }

  /**
   * Gets the soil type suitable for the plant.
   *
   * @return The soil type suitable for the plant.
   */
  public SoilTypeEnum getSoilType() {
    return soilType;
  }

  /**
   * Gets the care level required for the plant.
   *
   * @return The care level required for the plant.
   */
  public CareLevelEnum getCareLevel() {
    return careLevel;
  }
}
