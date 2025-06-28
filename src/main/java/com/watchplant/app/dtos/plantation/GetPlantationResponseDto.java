package com.watchplant.app.dtos.plantation;

import com.watchplant.app.entities.Plantation;
import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;

/**
 * DTO for the response of fetching a plantation.
 * Contains the details of the fetched plantation.
 */
public class GetPlantationResponseDto {

  private final String name;
  private final Double sizeArea;

  private final SoilTypeEnum soilType;
  private final SunlightIncidenceEnum sunlightIncidence;

  /**
   * Constructor for GetPlantationResponseDto.
   *
   * @param plantation The fetched plantation.
   */
  public GetPlantationResponseDto(Plantation plantation) {
    this.name = plantation.getKey().getName();
    this.sizeArea = plantation.getSizeArea();
    this.soilType = plantation.getSoilType();
    this.sunlightIncidence = plantation.getSunlightIncidence();
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

    public SoilTypeEnum getSoilType() {
        return soilType;
    }

    public SunlightIncidenceEnum getSunlightIncidence() {
        return sunlightIncidence;
    }
}
