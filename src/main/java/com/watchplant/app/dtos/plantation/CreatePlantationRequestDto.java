package com.watchplant.app.dtos.plantation;

import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for creating a plantation.
 * Contains the required fields for creating a new plantation.
 */
public class CreatePlantationRequestDto {

  @NotBlank(message = "O nome é um campo obrigatório")
  private String name;

  @NotNull(message = "O tamanho da plantação é um campo obrigatório")
  @Min(value = 1, message = "A área de plantação deve ser maior ou igual a 1m²")
  private Double sizeArea;

  @NotNull(message = "O tipo de solo é um campo obrigatório")
  private SoilTypeEnum soilType;

  @NotNull(message = "A frequência da incidência solar é um campo obrigatório")
  private SunlightIncidenceEnum sunlightIncidence;

  /**
   * Constructor for CreatePlantationRequestDto.
   *
   * @param name The name of the plantation.
   * @param sizeArea The size area of the plantation.
   * @param soilType The soil type of the plantation.
   * @param sunlightIncidence The sunlight incidence of the plantation.
   */
  public CreatePlantationRequestDto(String name, Double sizeArea, @NotNull SoilTypeEnum soilType, @NotNull SunlightIncidenceEnum sunlightIncidence) {
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
