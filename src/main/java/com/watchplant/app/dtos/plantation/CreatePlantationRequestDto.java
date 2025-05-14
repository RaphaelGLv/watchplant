package com.watchplant.app.dtos.plantation;

import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;

/**
 * DTO for creating a plantation.
 * Contains the required fields for creating a new plantation.
 */
public class CreatePlantationRequestDto {

  private String name;
  private Double sizeArea;
  private SoilTypeEnum soilType;
  private SunlightIncidenceEnum sunlightIncidence;

  /**
   * Constructor for CreatePlantationRequestDto.
   *
   * @param name The name of the plantation.
   * @param sizeArea The size area of the plantation.
   * @param soilType The soil type of the plantation.
   * @param sunlightIncidence The sunlight incidence of the plantation.
   */
  public CreatePlantationRequestDto(String name, Double sizeArea, SoilTypeEnum soilType, SunlightIncidenceEnum sunlightIncidence) {
    this.name = name;
    this.sizeArea = sizeArea;
    this.soilType = soilType;
    this.sunlightIncidence = sunlightIncidence;
  }

  /**
   * Gets the name of the plantation.
   *
   * @return The name of the plantation.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the size area of the plantation.
   *
   * @return The size area of the plantation.
   */
  public Double getSizeArea() {
    return sizeArea;
  }

  /**
   * Gets the soil type of the plantation.
   *
   * @return The soil type of the plantation.
   */
  public SoilTypeEnum getSoilType() {
    return soilType;
  }

  /**
   * Gets the sunlight incidence of the plantation.
   *
   * @return The sunlight incidence of the plantation.
   */
  public SunlightIncidenceEnum getSunlightIncidence() {
    return sunlightIncidence;
  }
}
