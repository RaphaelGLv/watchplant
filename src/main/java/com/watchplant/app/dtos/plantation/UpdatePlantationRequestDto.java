package com.watchplant.app.dtos.plantation;

import com.watchplant.app.entities.keys.PlantationKey;
import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;
import jakarta.validation.constraints.Min;

import java.util.Optional;
import java.util.UUID;

/**
 * DTO for updating a plantation.
 * Contains optional fields for updating specific attributes of a plantation.
 */
public class UpdatePlantationRequestDto {
  private PlantationKey key;

  @Min(value = 1, message = "A área de plantação deve ser maior ou igual a 1m²")
  private Double sizeArea;
  private SoilTypeEnum soilType;
  private SunlightIncidenceEnum sunlightIncidence;

  /**
   * Constructor for UpdatePlantationRequestDto.
   *
   * @param sizeArea The new size area of the plantation (nullable).
   * @param soilType The new soil type of the plantation (nullable).
   * @param sunlightIncidence The new sunlight incidence of the plantation (nullable).
   */
  public UpdatePlantationRequestDto(Double sizeArea, SoilTypeEnum soilType, SunlightIncidenceEnum sunlightIncidence) {
    this.sizeArea = sizeArea;
    this.soilType = soilType;
    this.sunlightIncidence = sunlightIncidence;
  }

  /**
   * Gets the new size area of the plantation.
   *
   * @return An Optional containing the new size area of the plantation.
   */
  public Optional<Double> getSizeArea() {
    return Optional.ofNullable(sizeArea);
  }

  /**
   * Gets the new soil type of the plantation.
   *
   * @return An Optional containing the new soil type of the plantation.
   */
  public Optional<SoilTypeEnum> getSoilType() {
    return Optional.ofNullable(soilType);
  }

  /**
   * Gets the new sunlight incidence of the plantation.
   *
   * @return An Optional containing the new sunlight incidence of the plantation.
   */
  public Optional<SunlightIncidenceEnum> getSunlightIncidence() {
    return Optional.ofNullable(sunlightIncidence);
  }

    public PlantationKey getKey() {
        return key;
    }

    public void setKey(PlantationKey key) {
        this.key = key;
    }
}
