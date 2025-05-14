package com.watchplant.app.dtos.plantation;

import com.watchplant.app.entities.Plantation;

/**
 * DTO for the response of fetching a plantation.
 * Contains the details of the fetched plantation.
 */
public class GetPlantationResponseDto {

  private String name;
  private Double sizeArea;

  /**
   * Constructor for GetPlantationResponseDto.
   *
   * @param plantation The fetched plantation.
   */
  public GetPlantationResponseDto(Plantation plantation) {
    this.name = plantation.getName();
    this.sizeArea = plantation.getSizeArea();
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
}
