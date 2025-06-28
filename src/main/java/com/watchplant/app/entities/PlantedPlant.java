/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.entities;

import com.watchplant.app.entities.keys.PlantedPlantKey;
import com.watchplant.app.enums.*;
import com.watchplant.app.utils.PruningCount;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

/**
 *
 * @author pedro
 */
@Entity
public class PlantedPlant {

  @EmbeddedId
  private PlantedPlantKey key;

  private String scientificName;
  private String commonName;
  private Double maxFeetHeight;
  private PlantCycleEnum cycle;
  private WateringFrequencyEnum wateringFrequency;
  private SunlightIncidenceEnum sunlightIncidence;
  private List<Month> pruningMonth;
  private Integer pruningAmount;
  private IntervalEnum pruningInterval;
  private SoilTypeEnum soilType;
  private CareLevelEnum careLevel;

  private Integer quantity;
  private LocalDateTime lastWateringDate;

  /**
   * Constructor for Plant
   * @param scientificName The scientific name of the plant
   * @param commonName The common name of the plant
   * @param maxFeetHeight The maximum height of the plant in feet
   * @param cycle The life cycle of the plant
   * @param wateringFrequency The watering frequency of the plant
   * @param sunlightIncidence The sunlight incidence required by the plant
   * @param pruningMonth The month for pruning the plant
   * @param soilType The soil type suitable for the plant
   * @param careLevel The care level required for the plant
   * @throws IllegalArgumentException if scientificName or commonName is null or empty, or if maxFeetHeight is null or negative
   */
  public PlantedPlant(
          PlantedPlantKey plantedPlantKey,
          String scientificName,
          String commonName,
          Double maxFeetHeight,
          PlantCycleEnum cycle,
          List<Month> pruningMonth,
          PruningCount pruningCount,
          CareLevelEnum careLevel,
          WateringFrequencyEnum wateringFrequency,
          SunlightIncidenceEnum sunlightIncidence,
          SoilTypeEnum soilType,
          Integer quantity,
          LocalDateTime lastWateringDate
  ) {
    this.key = plantedPlantKey;
    this.scientificName = scientificName;
    this.commonName = commonName;
    this.maxFeetHeight = maxFeetHeight;
    this.cycle = cycle;
    this.wateringFrequency = wateringFrequency;
    this.sunlightIncidence = sunlightIncidence;
    this.pruningMonth = pruningMonth;
    this.pruningAmount = pruningCount.amount();
    this.pruningInterval = pruningCount.interval();
    this.soilType = soilType;
    this.careLevel = careLevel;
    this.quantity = quantity;
    this.lastWateringDate = lastWateringDate;
  }

  public PlantedPlant() {

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
  public List<Month> getPruningMonth() {
    return pruningMonth;
  }

  /**
   * Sets the pruning month of the plant
   * @param pruningMonth The pruning month of the plant
   */
  public void setPruningMonth(List<Month> pruningMonth) {
    this.pruningMonth = pruningMonth;
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

    public Integer getQuantity() {
        return quantity;
    }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getPruningAmount() {
        return pruningAmount;
    }

    public IntervalEnum getPruningInterval() {
        return pruningInterval;
    }

    public LocalDateTime getLastWateringDate() {
        return lastWateringDate;
    }

    public PlantedPlantKey getKey() {
        return key;
    }
}
