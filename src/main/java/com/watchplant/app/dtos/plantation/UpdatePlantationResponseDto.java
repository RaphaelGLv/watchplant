package com.watchplant.app.dtos.plantation;

import com.watchplant.app.entities.Plantation;
import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;

import java.util.UUID;

/**
 * DTO for the response of updating a plantation.
 * Contains the updated details of the plantation.
 */
public class UpdatePlantationResponseDto {

  private String name;
  private Double sizeArea;

  private SoilTypeEnum soilType;
  private SunlightIncidenceEnum sunlightIncidence;


  /**
   * Constructor for UpdatePlantationResponseDto.
   *
   * @param plantation The updated plantation.
   */
  public UpdatePlantationResponseDto(Plantation plantation) {
    this.name = plantation.getKey().getName();
    this.sizeArea = plantation.getSizeArea();
    this.soilType = plantation.getSoilType();
    this.sunlightIncidence = plantation.getSunlightIncidence();
  }

  public String getName() {
    return name;
  }

  public Double getSizeArea() {
    return sizeArea;
  }

    public SoilTypeEnum getSoilType() {
        return soilType;
    }

    public SunlightIncidenceEnum getSunlightIncidence() {
        return sunlightIncidence;
    }
}