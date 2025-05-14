package com.watchplant.app.dtos.plantation;

import com.watchplant.app.entities.Plantation;

/**
 * DTO for the response of updating a plantation.
 * Contains the updated details of the plantation.
 */
public class UpdatePlantationResponseDto {

  private String name;
  private Double sizeArea;

  /**
   * Constructor for UpdatePlantationResponseDto.
   *
   * @param plantation The updated plantation.
   */
  public UpdatePlantationResponseDto(Plantation plantation) {
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
