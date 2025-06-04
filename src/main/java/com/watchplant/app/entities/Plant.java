/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.entities;

import com.watchplant.app.enums.CareLevelEnum;
import com.watchplant.app.enums.PlantCycleEnum;
import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;
import com.watchplant.app.enums.WateringFrequencyEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

/**
 *
 * @author pedro
 */
@Entity
public class Plant {

  @Id
  private UUID id;

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
   * Constructor for Plant
   * @param scientificName The scientific name of the plant
   * @param commonName The common name of the plant
   * @param maxFeetHeight The maximum height of the plant in feet
   * @param cycle The life cycle of the plant
   * @param wateringFrequency The watering frequency of the plant
   * @param sunlightIncidence The sunlight incidence required by the plant
   * @param pruningMonth The month for pruning the plant
   * @param pruningCountYearly The yearly pruning count for the plant
   * @param soilType The soil type suitable for the plant
   * @param careLevel The care level required for the plant
   * @throws IllegalArgumentException if scientificName or commonName is null or empty, or if maxFeetHeight is null or negative
   */
  public Plant(
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
    if (scientificName == null || scientificName.isEmpty()) {
      throw new IllegalArgumentException(
        "Scientific name cannot be null or empty"
      );
    }
    if (commonName == null || commonName.isEmpty()) {
      throw new IllegalArgumentException("Common name cannot be null or empty");
    }
    if (maxFeetHeight == null || maxFeetHeight < 0) {
      throw new IllegalArgumentException(
        "Max feet height cannot be null or negative"
      );
    }
    this.id = UUID.randomUUID();
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
   * Gets the ID of the plant
   * @return The ID of the plant
   */
  public UUID getId() {
    return id;
  }

  /**
   * Gets the scientific name of the plant
   * @return The scientific name of the plant
   */
  public String getScientificName() {
    return scientificName;
  }

  /**
   * Sets the scientific name of the plant
   * @param scientificName The scientific name of the plant
   * @throws IllegalArgumentException if scientificName is null or empty
   */
  public void setScientificName(String scientificName) {
    if (scientificName == null || scientificName.isEmpty()) {
      throw new IllegalArgumentException(
        "Scientific name cannot be null or empty"
      );
    }
    this.scientificName = scientificName;
  }

  /**
   * Gets the common name of the plant
   * @return The common name of the plant
   */
  public String getCommonName() {
    return commonName;
  }

  /**
   * Sets the common name of the plant
   * @param commonName The common name of the plant
   * @throws IllegalArgumentException if commonName is null or empty
   */
  public void setCommonName(String commonName) {
    if (commonName == null || commonName.isEmpty()) {
      throw new IllegalArgumentException("Common name cannot be null or empty");
    }
    this.commonName = commonName;
  }

  /**
   * Gets the maximum height of the plant in feet
   * @return The maximum height of the plant in feet
   */
  public Double getMaxFeetHeight() {
    return maxFeetHeight;
  }

  /**
   * Sets the maximum height of the plant in feet
   * @param maxFeetHeight The maximum height of the plant in feet
   * @throws IllegalArgumentException if maxFeetHeight is null or negative
   */
  public void setMaxFeetHeight(Double maxFeetHeight) {
    if (maxFeetHeight == null || maxFeetHeight < 0) {
      throw new IllegalArgumentException(
        "Max feet height cannot be null or negative"
      );
    }
    this.maxFeetHeight = maxFeetHeight;
  }

  /**
   * Gets the life cycle of the plant
   * @return The life cycle of the plant
   */
  public PlantCycleEnum getCycle() {
    return cycle;
  }

  /**
   * Sets the life cycle of the plant
   * @param cycle The life cycle of the plant
   */
  public void setCycle(PlantCycleEnum cycle) {
    this.cycle = cycle;
  }

  /**
   * Gets the watering frequency of the plant
   * @return The watering frequency of the plant
   */
  public WateringFrequencyEnum getWateringFrequency() {
    return wateringFrequency;
  }

  /**
   * Sets the watering frequency of the plant
   * @param wateringFrequency The watering frequency of the plant
   */
  public void setWateringFrequency(WateringFrequencyEnum wateringFrequency) {
    this.wateringFrequency = wateringFrequency;
  }

  /**
   * Gets the sunlight incidence required by the plant
   * @return The sunlight incidence required by the plant
   */
  public SunlightIncidenceEnum getSunlightIncidence() {
    return sunlightIncidence;
  }

  /**
   * Sets the sunlight incidence required by the plant
   * @param sunlightIncidence The sunlight incidence required by the plant
   */
  public void setSunlightIncidence(SunlightIncidenceEnum sunlightIncidence) {
    this.sunlightIncidence = sunlightIncidence;
  }

  /**
   * Gets the pruning month of the plant
   * @return The pruning month of the plant
   */
  public int getPruningMonth() {
    return pruningMonth;
  }

  /**
   * Sets the pruning month of the plant
   * @param pruningMonth The pruning month of the plant
   */
  public void setPruningMonth(int pruningMonth) {
    this.pruningMonth = pruningMonth;
  }

  /**
   * Gets the yearly pruning count of the plant
   * @return The yearly pruning count of the plant
   */
  public int getPruningCountYearly() {
    return pruningCountYearly;
  }

  /**
   * Sets the yearly pruning count of the plant
   * @param pruningCountYearly The yearly pruning count of the plant
   */
  public void setPruningCountYearly(int pruningCountYearly) {
    this.pruningCountYearly = pruningCountYearly;
  }

  /**
   * Gets the soil type suitable for the plant
   * @return The soil type suitable for the plant
   */
  public SoilTypeEnum getSoilType() {
    return soilType;
  }

  /**
   * Sets the soil type suitable for the plant
   * @param soilType The soil type suitable for the plant
   */
  public void setSoilType(SoilTypeEnum soilType) {
    this.soilType = soilType;
  }

  /**
   * Gets the care level required for the plant
   * @return The care level required for the plant
   */
  public CareLevelEnum getCareLevel() {
    return careLevel;
  }

  /**
   * Sets the care level required for the plant
   * @param careLevel The care level required for the plant
   */
  public void setCareLevel(CareLevelEnum careLevel) {
    this.careLevel = careLevel;
  }
}
