package com.watchplant.app.dtos.plantation;

import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;
import java.util.Optional;
import java.util.UUID;

/**
 * DTO for updating a plantation.
 * Contains optional fields for updating specific attributes of a plantation.
 */
public class UpdatePlantationRequestDto {

  private String name;
  private Optional<Double> sizeArea;
  private Optional<SoilTypeEnum> soilType;
  private Optional<SunlightIncidenceEnum> sunlightIncidence;

  /**
   * Constructor for UpdatePlantationRequestDto.
   *
   * @param name The new name of the plantation (nullable).
   * @param sizeArea The new size area of the plantation (nullable).
   * @param soilType The new soil type of the plantation (nullable).
   * @param sunlightIncidence The new sunlight incidence of the plantation (nullable).
   */
  public UpdatePlantationRequestDto(String name, Double sizeArea, SoilTypeEnum soilType, SunlightIncidenceEnum sunlightIncidence) {
    this.name = name;
    this.sizeArea = Optional.ofNullable(sizeArea);
    this.soilType = Optional.ofNullable(soilType);
    this.sunlightIncidence = Optional.ofNullable(sunlightIncidence);
  }

  /**
   * Gets the new name of the plantation.
   *
   * @return An Optional containing the new name of the plantation.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the new size area of the plantation.
   *
   * @return An Optional containing the new size area of the plantation.
   */
  public Optional<Double> getSizeArea() {
    return sizeArea;
  }

  /**
   * Gets the new soil type of the plantation.
   *
   * @return An Optional containing the new soil type of the plantation.
   */
  public Optional<SoilTypeEnum> getSoilType() {
    return soilType;
  }

  /**
   * Gets the new sunlight incidence of the plantation.
   *
   * @return An Optional containing the new sunlight incidence of the plantation.
   */
  public Optional<SunlightIncidenceEnum> getSunlightIncidence() {
    return sunlightIncidence;
  }
}
