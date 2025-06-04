package com.watchplant.app.dtos.plantation;

import com.watchplant.app.entities.Plantation;

/**
 * DTO for the response of creating a plantation.
 * Contains the details of the created plantation.
 */
public class CreatePlantationResponseDto {

  private String name;
  private Double sizeArea;

  /**
   * Constructor for CreatePlantationResponseDto.
   *
   * @param plantation The created plantation.
   */
  public CreatePlantationResponseDto(Plantation plantation) {
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
