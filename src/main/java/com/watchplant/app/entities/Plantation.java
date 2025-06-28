/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.entities;

import com.watchplant.app.entities.keys.PlantationKey;
import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;
import jakarta.persistence.*;

import java.util.UUID;

/**
 *
 * @author pedro
 */
@Entity
public class Plantation {

  @EmbeddedId
  private PlantationKey key;

  private Double sizeArea;
  private SoilTypeEnum soilType;
  private SunlightIncidenceEnum sunlightIncidence;

  public Plantation(
          PlantationKey key,
          Double sizeArea,
          SoilTypeEnum soilType,
          SunlightIncidenceEnum sunlightIncidence
  ) {
    this.key = key;
    this.sizeArea = sizeArea;
    this.soilType = soilType;
    this.sunlightIncidence = sunlightIncidence;
  }

  public Plantation() {}

  /**
   * Gets the size area of the plantation
   * @return The size area of the plantation
   */
  public Double getSizeArea() {
    return sizeArea;
  }

  /**
   * Sets the size area of the plantation
   * @param sizeArea The size area of the plantation
   */
  public void setSizeArea(Double sizeArea) {
    if (sizeArea == null || sizeArea < 0) {
      throw new IllegalArgumentException(
        "Size area cannot be null or negative"
      );
    }
    this.sizeArea = sizeArea;
  }

  /**
   * Gets the soil type of the plantation
   * @return The soil type of the plantation
   */
  public SoilTypeEnum getSoilType() {
    return soilType;
  }

  /**
   * Sets the soil type of the plantation
   * @param soilType The soil type of the plantation
   */
  public void setSoilType(SoilTypeEnum soilType) {
    this.soilType = soilType;
  }

  /**
   * Gets the sunlight incidence of the plantation
   * @return The sunlight incidence of the plantation
   */
  public SunlightIncidenceEnum getSunlightIncidence() {
    return sunlightIncidence;
  }


  public void setSunlightIncidence(SunlightIncidenceEnum sunlightIncidence) {
    this.sunlightIncidence = sunlightIncidence;
  }

  public PlantationKey getKey() {
      return key;
  }
}
