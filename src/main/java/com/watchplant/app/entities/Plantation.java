/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.entities;

import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

/**
 *
 * @author pedro
 */
@Entity
public class Plantation {

  @Id
  private UUID id;

  private UUID ownerId;
  private String name;
  private Double sizeArea;
  private SoilTypeEnum soilType;
  private SunlightIncidenceEnum sunlightIncidence;

  /**
   * Constructor for Plantation
   * @param name The name of the plantation
   * @param sizeArea The size area of the plantation
   * @param soilType The soil type of the plantation
   * @param sunlightIncidence The sunlight incidence of the plantation
   * @throws IllegalArgumentException if name is null or empty, or if sizeArea is null or negative
   */
  public Plantation(
          UUID ownerId,
          String name,
          Double sizeArea,
          SoilTypeEnum soilType,
          SunlightIncidenceEnum sunlightIncidence
  ) {
    this.ownerId = ownerId;
    this.id = UUID.randomUUID();
    this.name = name;
    this.sizeArea = sizeArea;
    this.soilType = soilType;
    this.sunlightIncidence = sunlightIncidence;
  }

  public Plantation() {}

  /**
   * Gets the ID of the plantation
   * @return The ID of the plantation
   */
  public UUID getId() {
    return id;
  }

  /**
   * Gets the name of the plantation
   * @return The name of the plantation
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the plantation
   * @param name The name of the plantation
   */
  public void setName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    this.name = name;
  }

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

  /**
   * Sets the sunlight incidence of the plantation
   * @param sunlightIncidence The sunlight incidence of the plantation
   */
  public void setSunlightIncidence(SunlightIncidenceEnum sunlightIncidence) {
    this.sunlightIncidence = sunlightIncidence;
  }

    public UUID getOwnerId() {
        return ownerId;
    }
}
