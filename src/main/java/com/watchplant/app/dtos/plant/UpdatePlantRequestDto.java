package com.watchplant.app.dtos.plant;

import com.watchplant.app.enums.*;
import java.util.Optional;
import java.util.UUID;

/**
 * DTO for updating a {@link Plant}.
 * Contains optional fields for updating specific attributes of a plant.
 */
public class UpdatePlantRequestDto {

  private UUID id;
  private Optional<String> scientificName;
  private Optional<String> commonName;
  private Optional<Double> maxFeetHeight;
  private Optional<PlantCycleEnum> cycle;
  private Optional<WateringFrequencyEnum> wateringFrequency;
  private Optional<SunlightIncidenceEnum> sunlightIncidence;
  private Optional<Integer> pruningMonth;
  private Optional<Integer> pruningCountYearly;
  private Optional<SoilTypeEnum> soilType;
  private Optional<CareLevelEnum> careLevel;

  /**
   * Constructor for {@link UpdatePlantRequestDto}.
   *
   * @param id The ID of the plant to update.
   * @param scientificName The new scientific name of the plant (nullable).
   * @param commonName The new common name of the plant (nullable).
   * @param maxFeetHeight The new maximum height of the plant in feet (nullable).
   * @param cycle The new life cycle of the plant (nullable).
   * @param wateringFrequency The new watering frequency of the plant (nullable).
   * @param sunlightIncidence The new sunlight incidence of the plant (nullable).
   * @param pruningMonth The new pruning month of the plant (nullable).
   * @param pruningCountYearly The new yearly pruning count of the plant (nullable).
   * @param soilType The new soil type of the plant (nullable).
   * @param careLevel The new care level of the plant (nullable).
   */
  public UpdatePlantRequestDto(
    UUID id,
    String scientificName,
    String commonName,
    Double maxFeetHeight,
    PlantCycleEnum cycle,
    WateringFrequencyEnum wateringFrequency,
    SunlightIncidenceEnum sunlightIncidence,
    Integer pruningMonth,
    Integer pruningCountYearly,
    SoilTypeEnum soilType,
    CareLevelEnum careLevel
  ) {
    this.id = id;
    this.scientificName = Optional.ofNullable(scientificName);
    this.commonName = Optional.ofNullable(commonName);
    this.maxFeetHeight = Optional.ofNullable(maxFeetHeight);
    this.cycle = Optional.ofNullable(cycle);
    this.wateringFrequency = Optional.ofNullable(wateringFrequency);
    this.sunlightIncidence = Optional.ofNullable(sunlightIncidence);
    this.pruningMonth = Optional.ofNullable(pruningMonth);
    this.pruningCountYearly = Optional.ofNullable(pruningCountYearly);
    this.soilType = Optional.ofNullable(soilType);
    this.careLevel = Optional.ofNullable(careLevel);
  }

  /**
   * Gets the ID of the plant.
   *
   * @return The ID of the plant.
   */
  public UUID getId() {
    return id;
  }

  /**
   * Gets the scientific name of the plant.
   *
   * @return An {@link Optional} containing the scientific name of the plant.
   */
  public Optional<String> getScientificName() {
    return scientificName;
  }

  /**
   * Gets the common name of the plant.
   *
   * @return An {@link Optional} containing the common name of the plant.
   */
  public Optional<String> getCommonName() {
    return commonName;
  }

  /**
   * Gets the maximum height of the plant in feet.
   *
   * @return An {@link Optional} containing the maximum height of the plant in feet.
   */
  public Optional<Double> getMaxFeetHeight() {
    return maxFeetHeight;
  }

  /**
   * Gets the life cycle of the plant.
   *
   * @return An {@link Optional} containing the life cycle of the plant.
   */
  public Optional<PlantCycleEnum> getCycle() {
    return cycle;
  }

  /**
   * Gets the watering frequency of the plant.
   *
   * @return An {@link Optional} containing the watering frequency of the plant.
   */
  public Optional<WateringFrequencyEnum> getWateringFrequency() {
    return wateringFrequency;
  }

  /**
   * Gets the sunlight incidence of the plant.
   *
   * @return An {@link Optional} containing the sunlight incidence of the plant.
   */
  public Optional<SunlightIncidenceEnum> getSunlightIncidence() {
    return sunlightIncidence;
  }

  /**
   * Gets the pruning month of the plant.
   *
   * @return An {@link Optional} containing the pruning month of the plant.
   */
  public Optional<Integer> getPruningMonth() {
    return pruningMonth;
  }

  /**
   * Gets the yearly pruning count of the plant.
   *
   * @return An {@link Optional} containing the yearly pruning count of the plant.
   */
  public Optional<Integer> getPruningCountYearly() {
    return pruningCountYearly;
  }

  /**
   * Gets the soil type of the plant.
   *
   * @return An {@link Optional} containing the soil type of the plant.
   */
  public Optional<SoilTypeEnum> getSoilType() {
    return soilType;
  }

  /**
   * Gets the care level of the plant.
   *
   * @return An {@link Optional} containing the care level of the plant.
   */
  public Optional<CareLevelEnum> getCareLevel() {
    return careLevel;
  }
}
